package voice_quiz_game_project.voice_quiz_game.recognizer;

import org.vosk.LogLevel;
import org.vosk.Model;
import org.vosk.Recognizer;
import org.vosk.LibVosk;

import javax.sound.sampled.*;
import java.io.IOException;

public class SpeechRecognizer implements AutoCloseable {
    private final Recognizer recognizer;
    private final TargetDataLine line;

    public SpeechRecognizer(String modelpath) throws Exception {
        LibVosk.setLogLevel(LogLevel.INFO);  // 로그 레벨 설정 (optional)
        Model model = new Model(modelpath);
        recognizer = new Recognizer(model, 16000);

        AudioFormat format = new AudioFormat(16000, 16, 1, true, false);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        if (!AudioSystem.isLineSupported(info)) {
            throw new RuntimeException("Line not supported");
        }

        line = (TargetDataLine) AudioSystem.getLine(info);
        line.open(format);
        line.start();
    }

    public String recognizeOnce() throws Exception {
        byte[] buffer = new byte[4096];
        int bytesRead = line.read(buffer, 0, buffer.length);

        if (recognizer.acceptWaveForm(buffer, bytesRead)) {
            return recognizer.getResult();
        }
        else {
            return recognizer.getPartialResult();
        }
    }

    public String listenAndRecognize(int durationSeconds) throws IOException {
        byte[] buffer = new byte[4096];
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < durationSeconds * 1000) {
            int bytesRead = line.read(buffer, 0, buffer.length);
            if (recognizer.acceptWaveForm(buffer, bytesRead)) {
                return recognizer.getResult();
            }
        }
        return recognizer.getFinalResult();  // 시간 초과 시 마지막 결관
    }


    @Override
    public void close() {
        line.stop();
        line.close();
        recognizer.close();
    }
}
