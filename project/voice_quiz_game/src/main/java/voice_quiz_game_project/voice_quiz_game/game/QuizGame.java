package voice_quiz_game_project.voice_quiz_game.game;

import voice_quiz_game_project.voice_quiz_game.recognizer.SpeechRecognizer;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.List;

public class QuizGame {
    private final List<Question> questions = List.of (
            new Question("사과를 영어로 말해보세요.", "apple"),
            new Question("고양이를 영어로 말해보세요.", "cat")
    );

    public void start() {
        System.out.println("음성 게임 퀴즈 시작! 아래 질문에 대답해 보세요:");
        System.out.println("Q1.대한민국의 수도는 어디인가요?");

        try (SpeechRecognizer recognizer = new SpeechRecognizer("model/vosk-model-small-ko-0.22")) {
            System.out.println("답변을 음성으로 말해주세요 (5초 내):");
            String resultJson = recognizer.listenAndRecognize(5);
            System.out.println("인식 결과(JSON): " + resultJson);
            // JSON 파싱하여 텍스트만 추출하거나, 문자열 유사도 비교 추가 가능
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
