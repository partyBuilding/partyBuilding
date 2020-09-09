package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.bean.Document;
import cn.bdqn.biz.Service.DocumentService;
import cn.bdqn.dao.mapper.DocumentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Resource
    private DocumentMapper documentMapper;

    @Transactional
    @Override
    public boolean addDocument(Document document) {
        return documentMapper.addDocument(document);
    }

    @Transactional
    @Override
    public boolean updateDocument(Document document) {
        return documentMapper.updateDocument(document);
    }

    @Transactional
    @Override
    public boolean delDocument(int id) {
        return documentMapper.delDocument(id);
    }

    @Override
    public List<Document> DocumentPageAll(Document document) {
        return documentMapper.DocumentPageAll(document);
    }

    @Override
    public Document getDocumentDetails(int id) {
        return documentMapper.getDocumentDetails(id);
    }
}
