package com.learzhu.browser.test.decode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZY on 2017/6/16.
 */
public class NovelParse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, List<NovelParseNode> > novelParseList;

    static public final String PARSE_NODE_LIST_TYPE_TITLE = "titleParseNodeList";
    static public final String PARSE_NODE_LIST_TYPE_CONTENT = "contentParseNodeList";
    static public final String PARSE_NODE_LIST_TYPE_PARAGRAPH = "paragraphParseNodeList";
    static public final String PARSE_NODE_LIST_TYPE_VIP = "vipParseNodeList";


    public NovelParse(List<NovelParseNode>  titleParseNodeList,
                      List<NovelParseNode>  contentParseNodeList,
                      List<NovelParseNode> paragraphParseNodeList,
                      List<NovelParseNode> vipParseNodeList)
    {
        super();

        if(contentParseNodeList == null)
        {
            throw  new NullPointerException("contentParseNodeList cannot be  null");
        }

        novelParseList = new HashMap<>();

        if(titleParseNodeList != null && titleParseNodeList.size() > 0)
        {
            novelParseList.put(PARSE_NODE_LIST_TYPE_TITLE, titleParseNodeList);
        }

        if(contentParseNodeList != null && contentParseNodeList.size() > 0)
        {
            novelParseList.put(PARSE_NODE_LIST_TYPE_CONTENT, contentParseNodeList);
        }

        if(paragraphParseNodeList != null && paragraphParseNodeList.size() > 0)
        {
            novelParseList.put(PARSE_NODE_LIST_TYPE_PARAGRAPH, paragraphParseNodeList);
        }

        if(vipParseNodeList != null && vipParseNodeList.size() > 0)
        {
            novelParseList.put(PARSE_NODE_LIST_TYPE_VIP, vipParseNodeList);
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Map<String, List<NovelParseNode>> getNovelParseList() {
        return novelParseList;
    }

    public void setNovelParseList(Map<String, List<NovelParseNode>> novelParseList) {
        novelParseList = novelParseList;
    }

    @Override
    public String toString() {
        return "NovelParse{" +
                "NovelParseList=" + novelParseList +
                '}';
    }
}
