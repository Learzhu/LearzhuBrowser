package com.learzhu.browser.test.decode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZY on 2017/6/16.
 */
public class NovelParseBuilder {

    static public NovelParse createDhzwDotOrgNovelParse() {

        List<NovelParseNode> titleParseNodeList = new ArrayList<NovelParseNode>();
        NovelParseNode novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_CLASS,
                0,
                "bookname");
        titleParseNodeList.add(novelParseNode);
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_TAG,
                0,
                "h1");
        titleParseNodeList.add(novelParseNode);

        List<NovelParseNode> contentParseNodeList = new ArrayList<NovelParseNode>();
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_ID,
                0,
                "BookText");
        contentParseNodeList.add(novelParseNode);

        List<NovelParseNode> paragraphParseNodeList = new ArrayList<NovelParseNode>();
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_BR,
                0,
                "");
        paragraphParseNodeList.add(novelParseNode);

        return new NovelParse(titleParseNodeList, contentParseNodeList, paragraphParseNodeList, null);
    }

    static public NovelParse createYssmDotOrgNovelParse() {
        List<NovelParseNode> titleParseNodeList = new ArrayList<NovelParseNode>();
        NovelParseNode novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_ID,
                0,
                "BookCon");
        titleParseNodeList.add(novelParseNode);
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_TAG,
                0,
                "h1");
        titleParseNodeList.add(novelParseNode);

        List<NovelParseNode> contentParseNodeList = new ArrayList<NovelParseNode>();
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_ID,
                0,
                "content");
        contentParseNodeList.add(novelParseNode);

        List<NovelParseNode> paragraphParseNodeList = new ArrayList<NovelParseNode>();
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_BR,
                0,
                "");
        paragraphParseNodeList.add(novelParseNode);

        return new NovelParse(titleParseNodeList, contentParseNodeList, paragraphParseNodeList, null);
    }


    static public NovelParse createQidianDotComNovelParse() {
        List<NovelParseNode> titleParseNodeList = new ArrayList<NovelParseNode>();
        NovelParseNode novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_ID,
                0,
                "chapterContent");
        titleParseNodeList.add(novelParseNode);
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_CLASS,
                0,
                "read-section");
        titleParseNodeList.add(novelParseNode);
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_TAG,
                0,
                "h3");
        titleParseNodeList.add(novelParseNode);
        //////////////////////////////////////////////////////////////////////
        List<NovelParseNode> contentParseNodeList = new ArrayList<NovelParseNode>();
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_ID,
                0,
                "chapterContent");
        contentParseNodeList.add(novelParseNode);
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_CLASS,
                0,
                "read-section");
        contentParseNodeList.add(novelParseNode);

        ///////////////////////////////////////////////////////////////////////
        List<NovelParseNode> paragraphParseNodeList = new ArrayList<NovelParseNode>();
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_TAG,
                -1,
                "p");
        paragraphParseNodeList.add(novelParseNode);

        /////////////////////////////////////
        List<NovelParseNode> vipParseNodeList = new ArrayList<NovelParseNode>();
        novelParseNode = new NovelParseNode(NovelParseNode.NODE_TYPE_CLASS,
                0,
                "read-btn-vip-login");
        vipParseNodeList.add(novelParseNode);

        return new NovelParse(titleParseNodeList, contentParseNodeList, paragraphParseNodeList, vipParseNodeList);
    }
}
