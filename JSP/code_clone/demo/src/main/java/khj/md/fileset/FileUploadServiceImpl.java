package khj.md.fileset;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import khj.md.fileset.path.Path;

import java.io.*;

// 주석 GPT가 달아줌

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String saveAtStore(MultipartFile file) {
        // 업로드된 파일의 원래 이름(original filename)을 가져옴
        String ofname = file.getOriginalFilename();

        // 확장자를 구하기 위해 마지막 '.'의 인덱스를 찾음
        int idx = ofname.lastIndexOf(".");

        // 파일명 앞부분 (확장자 제외 부분) → 잘못된 변수명: 여기서는 확장자 빼고 앞부분을 구해야 하지만 ext와 동일하게 작성됨
        String ofheader = ofname.substring(0, idx); // ← 수정 필요 (현재는 substring(idx)라서 확장자만 잘라옴)

        // 파일 확장자 (.jpg, .png 등)
        String ext = ofname.substring(idx);

        // 현재 시간을 밀리초 단위로 가져옴 → 파일명 중복 방지를 위해 사용
        long ms = System.currentTimeMillis();

        // 고유한 저장 파일명 만들기: "원본이름_현재시간.확장자" 형식
        StringBuilder sb = new StringBuilder();
        sb.append(ofheader);  // 원본 파일명(확장자 제외)
        sb.append("_");
        sb.append(ms);        // 유니크한 값 (현재 시간)
        sb.append(ext);       // 확장자
        String saveFileName = sb.toString();

        // 업로드된 파일의 크기 (byte 단위)
        long fsize = file.getSize();
        System.out.println("#ofname: " + ofname + ", saveFileName: "+ saveFileName + ", fsize: " + fsize);

        // 실제 파일을 저장하는 메소드 호출 (파일 객체, 저장할 파일명 전달)
        boolean flag = writeFile(file, saveFileName);

        // 저장 성공 여부 출력
        if (flag) {
            System.out.println("@업로드 성공");
        } else {
            System.out.println("@업로드 실패");
        }

        // 저장된 파일명을 반환
        
        return Path.FILE_STORE + saveFileName;
    }

   public boolean writeFile(MultipartFile file, String saveFileName) {
        // 파일 저장 경로 객체 생성 (Path.FILE_STORE는 미리 정의된 경로 상수)
        File dir = new File(Path.FILE_STORE);

        // 저장 경로가 존재하지 않으면 디렉토리 생성
        if(!dir.exists()) dir.mkdirs();

        FileOutputStream fos = null;
        try {
            // MultipartFile → 바이트 배열로 변환
            byte data[] = file.getBytes();

            // 저장할 파일 객체 생성 (저장 경로 + 파일명)
            fos = new FileOutputStream(Path.FILE_STORE + saveFileName);

            // 파일에 바이트 배열 쓰기
            fos.write(data);

            // 버퍼에 남아있는 데이터를 강제로 디스크에 기록
            fos.flush();

            // 모든 과정이 정상 완료되면 true 반환 (저장 성공)
            return true;
        } catch (IOException ie) {
            // 저장 중 예외 발생 시 false 반환 (저장 실패)
            return false;
        } finally {
            try {
                // 자원 해제: FileOutputStream이 열려 있으면 닫기
                if (fos != null) fos.close();
            } catch (IOException ie) {
                // close 과정에서 발생하는 예외는 무시 (로그만 남기는 게 일반적)
            }
        }
    }
}