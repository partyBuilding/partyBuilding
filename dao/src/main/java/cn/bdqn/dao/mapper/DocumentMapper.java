package cn.bdqn.dao.mapper;

import cn.bdqn.beans.bean.Document;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DocumentMapper {
    /**
     * 新增文档
     * @param document
     * @return
     */
    boolean addDocument(Document document);

    /**
     * 修改文档信息
     * @param document
     * @return
     */
    boolean updateDocument(Document document);

    /**
     * 删除文档
     * @param id
     * @return
     */
    boolean delDocument(@Param("id")int id);

    /**
     * 查询全部文档并分页 使用pagehelper分页
     * @param document
     * @return
     */
    List<Document> DocumentPageAll(Document document);

    /**
     * 根据文档id查看详情
     * @param id
     * @return
     */
    Document getDocumentDetails(@Param("id")int id);
}
