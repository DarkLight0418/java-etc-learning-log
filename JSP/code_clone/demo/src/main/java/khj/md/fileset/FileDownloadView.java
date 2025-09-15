package khj.md.fileset;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 주석 GPT가 달아줌

/**
 * 파일 다운로드 처리를 위한 커스텀 View 클래스
 * - Spring MVC의 AbstractView를 상속받아 구현
 * - Controller에서 model에 "downloadFile"이라는 key로 File 객체를 담아주면,
 *   이 View를 통해 브라우저로 파일이 전송되어 다운로드된다.
 */
public class FileDownloadView extends AbstractView {

    // 생성자: MIME 타입(Content-Type) 지정
    public FileDownloadView() {
        // "application/download"는 일반적인 다운로드 MIME 타입
        // charset은 UTF-8로 설정
        setContentType("application/download;charset=utf-8");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        // 컨트롤러에서 전달된 파일 객체 가져오기
        File file = (File) model.get("downloadFile");

        // 응답 헤더 설정
        response.setContentType(getContentType());     // 응답 타입 지정
        response.setContentLength((int) file.length()); // 파일 크기 설정 (Content-Length)

        // 브라우저에서 다운로드 대화상자가 뜨도록 헤더 설정
        // 파일 이름은 UTF-8로 인코딩해야 한글/특수문자가 깨지지 않음
        String value = "attachment; filename=" + java.net.URLEncoder.encode(file.getName(), "utf-8") + ";";
        response.setHeader("Content-Disposition", value);

        // 데이터 전송 형식을 binary로 지정 (텍스트가 아니라 파일 데이터)
        response.setHeader("Content-Transfer-Encoding", "binary");

        FileInputStream fis = null;             // 파일 입력 스트림 (근원지: 서버의 파일)
        OutputStream os = response.getOutputStream(); // 응답 출력 스트림 (목적지: 클라이언트 브라우저)

        try {
            // 파일을 읽어서 클라이언트로 전송
            fis = new FileInputStream(file);

            // Spring 유틸리티 클래스 사용: fis → os 로 복사
            FileCopyUtils.copy(fis, os);

            // 출력 스트림 비우기 (남아있는 데이터 강제 전송)
            os.flush();
        } catch (IOException ie) {
            // 다운로드 도중 예외 발생 시 처리 (현재는 생략)
        } finally {
            // 자원 정리: 입력/출력 스트림 닫기
            if (fis != null) fis.close();
            if (os != null) os.close();
        }
    }
}
