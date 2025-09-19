package khj.boot.repository;

import khj.boot.domain.Board;
import khj.boot.domain.PageInfo;

import java.util.List;

public interface BoardRepository {
    List<Board> listR(PageInfo pageInfo);
    Board insertR(Board board);
    boolean deleteR(long seq);
    Board contentR(long seq);
    int modifyR(Board board);
    int countBoardR();
    int selectBoardR(PageInfo pageInfo);

    List<Board> searchBySubjectR(String subject);
    List<Board> searchByContentR(String content);
    List<Board> searchByWriterR(String writer);
}
