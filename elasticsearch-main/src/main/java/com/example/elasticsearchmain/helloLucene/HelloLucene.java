package com.example.elasticsearchmain.helloLucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.nio.file.Paths;


/**
 * Lucene 使用的简单例子
 * <p>
 * https://www.bilibili.com/video/BV1FE41197An/?vd_source=762c708805c60f99f0744027b9b85d02
 */
@Component
public class HelloLucene {


    /**
     * 创建索引    每次调用一次这个方法都会重新创建索引文件，segement会 +1
     */
    public void index() {

        IndexWriter writer = null;
        try {

            //1、创建Directory     索引存在于什么地方 RAM是内存
            Directory directory = FSDirectory.open(Paths.get("src/main/resources/index/index1"));

            //2、创建IndexWriter   将文档写到索引里面
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new StandardAnalyzer());
            writer = new IndexWriter(directory, indexWriterConfig);

            //3、创建Document对象
            Document document = null;

            //4、为Document添加Field   文档的标题、大小、路径、内容
            File file = new File("src/main/resources/lucene");
            for (File f : file.listFiles()) {
                document = new Document();
                //这里添加文件的原始数据
                document.add(new Field("content", new FileReader(f)));
                //Field.Store.YES  需要将数据存储到索引中，Field.Index.NOT_ANALYZED  不需要分词
                document.add(new Field("filename", f.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                document.add(new Field("path", f.getAbsolutePath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                //5、为IndexWriter添加文档到索引
                writer.addDocument(document);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    /**
     * 搜索
     */
    public void seacher() {


        try {

            //1. 创建Directory
            Directory directory = FSDirectory.open(Paths.get("src/main/resources/index/index1"));

            //2. 创建IndexReader
            DirectoryReader reader = DirectoryReader.open(directory);

            //3. 根据IndexReader创建IndexSearcher
            IndexSearcher searcher = new IndexSearcher(reader);

            //4. 创建搜索的Query
            //创建parser来确定要搜索的内容
            QueryParser parser = new QueryParser("content", new StandardAnalyzer());
            //query表示搜索的域
            Query query = parser.parse("坚持");

            //5. 根据searcher搜索并且返回TopDocs
            TopDocs topDocs = searcher.search(query, 10);

            //6. 根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDoc = topDocs.scoreDocs;
            for (ScoreDoc doc : scoreDoc) {
                //7. 根据searcher和ScordDoc对象获取具体的Document对象
                Document d = searcher.doc(doc.doc);
                //8. 根据Document对象获取需要的值
                System.out.println("------------" + d.get("filename") + " " + d.get("path"));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }


}
