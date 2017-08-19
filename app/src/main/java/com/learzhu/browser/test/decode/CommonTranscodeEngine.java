//package com.learzhu.browser.test.decode;
//
//import android.util.LogTest;
//
//import com.zhangyou.domain.NovelContentAfterTranscode;
//
//import org.apache.commons.lang3.StringUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.nodes.TextNode;
//import org.jsoup.select.Elements;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by ZY on 2017/6/16.
// */
//public class CommonTranscodeEngine {
//    private static final String TAG = "CommonTranscodeEngine";
////    private static final Logger logger = LoggerFactory.getLogger(CommonTranscodeEngine.class);
//
//
//    static public NovelContentAfterTranscode transcodeNovelContentUrl(int novelId,
//                                                                      long chapterId,
//                                                                      String url,
//                                                                      NovelParse novelParse) {
//        NovelContentAfterTranscode novelContentAfterTranscode = null;
//        do {
//            if (novelParse == null)
//                break;
//
//            Map<String, List<NovelParseNode>> novelParseListMap = novelParse.getNovelParseList();
//            if (novelParseListMap == null)
//                break;
//
//            try {
//                Document doc = Jsoup.connect(url)
//                        .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/539.49 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36")
//                        .timeout(5000)
//                        .get();
//                if (doc == null)
//                    break;
//
//                Element body = doc.body();
//                if (body == null)
//                    break;
//
//                novelContentAfterTranscode = new NovelContentAfterTranscode(novelId, chapterId, url);
//
//                String title = null;
//
//                List<NovelParseNode> titleNovelParseNodeList = novelParseListMap.get(NovelParse.PARSE_NODE_LIST_TYPE_TITLE);
//                if (titleNovelParseNodeList != null && titleNovelParseNodeList.size() > 0) {
//                    Element element = body;
//                    for (NovelParseNode novelParseNode : titleNovelParseNodeList) {
//                        element = findElementByNovelParseNode(novelParseNode, element);
//                    }
//
//                    if (element != null) {
//                        title = element.ownText();
//                    }
//
//                    if (title != null && title.length() > 100)//too long , maybe error
//                        title = null;
//
//                    novelContentAfterTranscode.setChapterTitle(title);
//                }
//
//
//                List<NovelParseNode> novelParseNodeList = novelParseListMap.get(NovelParse.PARSE_NODE_LIST_TYPE_CONTENT);
//                if (novelParseNodeList != null && novelParseNodeList.size() > 0) {
//                    Element element = body;
//                    for (NovelParseNode novelParseNode : novelParseNodeList) {
//                        element = findElementByNovelParseNode(novelParseNode, element);
//                    }
//
//                    if (element != null) {
//                        List<NovelParseNode> paragraphParseNodeList = novelParseListMap.get(NovelParse.PARSE_NODE_LIST_TYPE_PARAGRAPH);
//                        List<String> novelContentStringList = getNovelContent(paragraphParseNodeList, element);
//                        for (String novelContentString : novelContentStringList) {
//                            novelContentAfterTranscode.addOneSectionText(novelContentString);
//                        }
//                    }
//                }
//
//                novelContentAfterTranscode.setVipChapter(0); //default is zero
//                List<NovelParseNode> vipParseNodeList = novelParseListMap.get(NovelParse.PARSE_NODE_LIST_TYPE_VIP);
//                if (vipParseNodeList != null && vipParseNodeList.size() > 0) {
//                    Element element = body;
//                    for (NovelParseNode novelParseNode : vipParseNodeList) {
//                        element = findElementByNovelParseNode(novelParseNode, element);
//                    }
//                    if (element != null) {
//                        novelContentAfterTranscode.setVipChapter(1);
//                    }
//                }
//            } catch (Exception e) {
//                LogTest.e(TAG, "transcodeNovelContentUrl error: " + e.toString());
//            }
//
//        } while (false);
//
//
//        return novelContentAfterTranscode;
//    }
//
//    private static Element findElementByNovelParseNode(NovelParseNode novelParseNode, Element parentElement) {
//        Element resultElement = null;
//
//        do {
//            try {
//                if (parentElement == null || novelParseNode == null)
//                    break;
//
//                if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_ID) {
//                    resultElement = parentElement.getElementById(novelParseNode.getNodeValue());
//                } else if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_CLASS) {
//
//                    Elements elements = parentElement.getElementsByClass(novelParseNode.getNodeValue());
//                    if (elements == null || novelParseNode.getNodeIndex() > elements.size() - 1)
//                        break;
//                    resultElement = elements.get(novelParseNode.getNodeIndex());
//                } else if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_TAG) {
//
//                    Elements elements = parentElement.getElementsByTag(novelParseNode.getNodeValue());
//                    if (elements == null || elements.size() - 1 < novelParseNode.getNodeIndex())
//                        break;
//                    resultElement = elements.get(novelParseNode.getNodeIndex());
//                } else if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_ATTRIBUTE) {
//
//                    Elements elements = parentElement.getElementsByAttribute(novelParseNode.getNodeValue());
//                    if (elements == null || elements.size() - 1 < novelParseNode.getNodeIndex())
//                        break;
//                    resultElement = elements.get(novelParseNode.getNodeIndex());
//                }
//            } catch (Exception e) {
//                LogTest.w(TAG, "findElementByNovelParseNode error: " + e.toString());
//            }
//
//
//        } while (false);
//
//        return resultElement;
//    }
//
//    private static List<String> getNovelContent(List<NovelParseNode> paragraphParseNodeList, Element novelContentElement) {
//        List<String> novelConentparagraphList = new ArrayList<>();
//
//        do {
//            if (novelContentElement == null
//                    || paragraphParseNodeList == null || paragraphParseNodeList.size() == 0)
//                break;
//
//            Elements paragraphElements = new Elements();
//            paragraphElements.add(novelContentElement);
//
//            for (NovelParseNode novelParseNode : paragraphParseNodeList) {
//                Elements subParagraphElements = new Elements();
//
//                if (paragraphElements == null || paragraphElements.size() == 0)
//                    break;
//
//                for (Element paragraphElement : paragraphElements) {
//
//                    if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_ID) {
//
//                        if (StringUtils.isBlank(novelParseNode.getNodeValue()))
//                            continue;
//
//                        Element subEle = paragraphElement.getElementById(novelParseNode.getNodeValue());
//                        subParagraphElements.add(subEle);
//                    } else if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_CLASS
//                            || novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_TAG
//                            || novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_ATTRIBUTE) {
//
//                        if (StringUtils.isBlank(novelParseNode.getNodeValue()))
//                            continue;
//
//                        Elements subEles = null;
//                        if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_CLASS) {
//                            subEles = paragraphElement.getElementsByClass(novelParseNode.getNodeValue());
//                        } else if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_TAG) {
//                            subEles = paragraphElement.getElementsByTag(novelParseNode.getNodeValue());
//                        } else if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_ATTRIBUTE) {
//                            subEles = paragraphElement.getElementsByAttribute(novelParseNode.getNodeValue());
//                        }
//
//                        if (subEles == null)
//                            continue;
//
//                        if (subEles == null || subEles.size() == 0)
//                            continue;
//                        if (novelParseNode.getNodeIndex() < 0) {
//                            for (Element subEle : subEles) {
//                                subParagraphElements.add(subEle);
//                            }
//                        } else if (novelParseNode.getNodeIndex() < subEles.size()) {
//                            Element subEle = subEles.get(novelParseNode.getNodeIndex());
//                            subParagraphElements.add(subEle);
//                        }
//
//                    } else if (novelParseNode.getNodeType() == NovelParseNode.NODE_TYPE_BR) {
//
//                        List<TextNode> textNodeList = paragraphElement.textNodes();
//
//                        for (TextNode textNode : textNodeList) {
//                            String text = textNode.text();
//                            if (StringUtils.isBlank(text) == false) {
//                                novelConentparagraphList.add(text);
//                            }
//                        }
//                    }
//
//                }
//
//                paragraphElements = subParagraphElements;
//            }
//
//
//            if (paragraphElements != null && paragraphElements.size() > 0) {
//                for (Element element : paragraphElements) {
//                    String text = element.ownText();
//                    if (StringUtils.isBlank(text) == false) {
//                        novelConentparagraphList.add(text);
//                    }
//                }
//            }
//
//
//        } while (false);
//
//        return novelConentparagraphList;
//    }
//
//}