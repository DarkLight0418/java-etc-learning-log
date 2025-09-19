package khj.boot.service;

import khj.boot.domain.Board;
import khj.boot.domain.PageInfo;

import java.util.List;

public interface BoardService {
    List<Board> listB(PageInfo pageInfo);
    Board insertB(Board board);
    void deleteB(long seq);
    Board contentB(long seq);
    int modifyB(Board board);
    int countBoard();
    int selectBoard(PageInfo pageInfo);

    List<Board> searchBySubject(String subject);
    List<Board> searchByContent(String content);
    List<Board> searchByWriter(String writer);
}
