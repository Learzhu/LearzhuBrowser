package com.learzhu.browser.test.decode;

import java.io.Serializable;

/**
 * Created by ZY on 2017/6/15.
 */
public class NovelParseNode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nodeTypeName;

    private int nodeType;

    private String nodeValue;

    private int nodeIndex;

    static public final int NODE_TYPE_ID = 1;
    static public final int NODE_TYPE_CLASS = 2;
    static public final int NODE_TYPE_TAG = 3;
    static public final int NODE_TYPE_ATTRIBUTE = 4;
    static public final int NODE_TYPE_BR = 10;

    public NovelParseNode(int nodeType, int nodeIndex, String nodeValue) {
        if (nodeType == NODE_TYPE_ID) {
            this.nodeTypeName = "id";
        } else if (nodeType == NODE_TYPE_CLASS) {
            this.nodeTypeName = "class";
        } else if (nodeType == NODE_TYPE_TAG) {
            this.nodeTypeName = "tag";
        } else if (nodeType == NODE_TYPE_ATTRIBUTE) {
            this.nodeTypeName = "attribute";
        } else if (nodeType == NODE_TYPE_BR) {
            this.nodeTypeName = "br";
        } else {
            throw new RuntimeException("NovelParseNode construction error : not valid nodeType");
        }

        this.nodeType = nodeType;
        this.nodeIndex = nodeIndex;
        this.nodeValue = nodeValue != null ? nodeValue : "";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNodeTypeName() {
        return nodeTypeName;
    }

    public void setNodeTypeName(String nodeTypeName) {
        this.nodeTypeName = nodeTypeName;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public int getNodeIndex() {
        return nodeIndex;
    }

    public void setNodeIndex(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    @Override
    public String toString() {
        return "NovelParseNode{" +
                "nodeTypeName='" + nodeTypeName + '\'' +
                ", nodeType=" + nodeType +
                ", nodeValue='" + nodeValue + '\'' +
                ", nodeIndex=" + nodeIndex +
                '}';
    }
}
