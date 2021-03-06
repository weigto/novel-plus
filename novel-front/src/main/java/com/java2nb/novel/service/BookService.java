package com.java2nb.novel.service;


import com.java2nb.novel.search.BookSP;
import com.java2nb.novel.vo.BookCommentVO;
import com.java2nb.novel.vo.BookSettingVO;
import com.java2nb.novel.entity.*;
import com.java2nb.novel.vo.BookVO;

import java.util.List;
import java.util.Map;

/**
 * @author 11797
 */
public interface BookService {

    /**
     * 查询首页小说设置列表数据
     * @return
     * */
    Map<Byte, List<BookSettingVO>> listBookSettingVO();

    /**
     * 查询首页点击榜单数据
     * @return
     * */
    List<Book> listClickRank();

    /**
     * 查询首页新书榜单数据
     * @return
     * */
    List<Book> listNewRank();

    /**
     * 查询首页更新榜单数据
     * @return
     * */
    List<BookVO> listUpdateRank();

    /**
     * 分页搜索
     * @param params 搜索参数
     * @param page 页码
     * @param pageSize 分页大小
     * @return 小说集合
     * */
    List<BookVO> searchByPage(BookSP params, int page, int pageSize);

    /**
     * 查询小说分类列表
     * @return 分类集合
     * */
    List<BookCategory> listBookCategory();

    /**
     * 查询小说详情信息
     * @return 书籍信息
     * @param id 书籍ID*/
    Book queryBookDetail(Long id);

    /**
     * 查询目录列表
     * @param bookId 书籍ID
     * @param orderBy 排序
     *@param limit 查询条数
     *@return 目录集合
     * */
    List<BookIndex> queryIndexList(Long bookId, String orderBy, Integer limit);

    /**
     * 查询目录
     * @param bookIndexId 目录ID
     * @return 目录信息
     * */
    BookIndex queryBookIndex(Long bookIndexId);

    /**
     * 查询上一章节目录ID
     * @param bookId 书籍ID
     * @param indexNum 目录号
     * @return 上一章节目录ID，没有则返回0
     * */
    Long queryPreBookIndexId(Long bookId, Integer indexNum);

    /**
     * 查询下一章目录ID
     * @param bookId 书籍ID
     * @param indexNum 目录号
     * @return 下一章节目录ID，没有则返回0
     * */
    Long queryNextBookIndexId(Long bookId, Integer indexNum);

    /**
     * 查询章节内容
     * @param bookIndexId 目录ID
     * @return 书籍内容
     * */
    BookContent queryBookContent(Long bookIndexId);

    /**
     * 查询小说排行信息
     * @param type 排行类型，0点击排行，1新书排行，2更新排行
     * @param limit 查询条数
     * @return 小说集合
     * */
    List<Book> listRank(Byte type, Integer limit);

    /**
     * 增加点击次数
     * @param bookId 书籍ID
     * */
    void addVisitCount(Long bookId);

    /**
     * 查询章节数
     * @param bookId 书籍ID
     * @return 章节数量
     * */
    long queryIndexCount(Long bookId);

    /**
     * 根据分类id查询同类推荐书籍
     * @param catId 分类id
     * @return 书籍集合
     * */
    List<Book> listRecBookByCatId(Integer catId);

    /**
     * 查询首章目录ID
     * @param bookId 书籍ID
     * @return 首章目录ID
     * */
    Long queryFirstBookIndexId(Long bookId);

    /**
     *分页查询书籍评论列表
     * @param userId 用户ID
     * @param bookId 书籍ID
     * @param page 页码
     * @param pageSize 分页大小
     * @return 评论集合
     * */
    List<BookCommentVO> listCommentByPage(Long userId, Long bookId, int page, int pageSize);

    /**
     * 新增评价
     * @param userId 用户ID
     * @param comment 评论内容
     * */
    void addBookComment(Long userId, BookComment comment);

    /**
     * 通过作者名获取或创建作者Id
     * @param authorName 作者名
     * @param workDirection 作品方向
     * @return 作者ID
     * */
    Long getOrCreateAuthorIdByName(String authorName, Byte workDirection);



    /**
     * 查询小说ID
     * @param bookName 书名
     * @param author 作者名
     * @return 小说ID
     * */
    Long queryIdByNameAndAuthor(String bookName, String author);

    /**
     * 根据小说ID查询目录号集合
     * @param bookId 小说ID
     * @return 目录号集合
     * */
    List<Integer> queryIndexNumByBookId(Long bookId);

    /**
     * 查询网络图片的小说
     * @param limit 查询条数
     * @param offset 开始行数
     * @return 返回小说集合
     * */
    List<Book> queryNetworkPicBooks(Integer limit, Integer offset);


    /**
     * 更新小说网络图片到本地
     * @param picUrl 网络图片路径
     * @param bookId 小说ID
     */
    void updateBookPicToLocal(String picUrl, Long bookId);
}
