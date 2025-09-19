package khj.boot.service;

import khj.boot.domain.Board;
import khj.boot.domain.PageInfo;
import khj.boot.repository.JdbcMariaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JdbcTemplateMariaBoardService implements BoardService {

    @Autowired
    JdbcMariaBoardRepository jdbcMariaBoardRepository;

    @Override
    public List<Board> listB(PageInfo pageInfo) {
        return jdbcMariaBoardRepository.listR(pageInfo);
    }

    @Override
    public Board insertB(Board board) {
        return jdbcMariaBoardRepository.insertR(board);
    }

    @Override
    public void deleteB(long seq) {
        jdbcMariaBoardRepository.deleteR(seq);
    }

    @Override
    public Board contentB(long seq) {
        return jdbcMariaBoardRepository.contentR(seq);
    }

    @Override
    public int modifyB(Board board) {
        return jdbcMariaBoardRepository.modifyR(board);
    }

    @Override
    public int countBoard() {
        return jdbcMariaBoardRepository.countBoardR();
    }

    @Override
    public int selectBoard(PageInfo pageInfo) {
        return jdbcMariaBoardRepository.selectBoardR(pageInfo);
    }

    @Override
    public List<Board> searchBySubject(String subject) {
        return jdbcMariaBoardRepository.searchBySubjectR(subject);
    }

    @Override
    public List<Board> searchByContent(String content) {
        return jdbcMariaBoardRepository.searchByContentR(content);
    }

    @Override
    public List<Board> searchByWriter(String writer) {
        return jdbcMariaBoardRepository.searchByWriterR(writer);
    }
}
