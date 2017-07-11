package com.learzhu.browser.test.json;

import java.io.Serializable;

/**
 * ChapterBean.java是极搜浏览器的章节的类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/4/25 14:24
 * @update UserName 2017/4/25 14:24
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class ChapterBean implements Serializable {
    //因为可能超过int上限
    public long chapterId;
    public int novelId;

    //用于关联卷ID
    public int volumeId;
    public String title;
    public int wordCount;
    public int sort;
    public String createDatetime;
    //保存网页内容的URL
    public String contentUrl;

    //新增的用于判断是否已经缓存
    public boolean isCached;
    //保存是否已经选中
    public boolean isSelected;
    //保存是否是当前列表的最后一项
    public boolean isLastItem;
    //保存当前小说是否已经阅读
    public boolean isReaded;
    //保存当前的小说的章节的ID
    public long currentChapterId;

    //新增字段用于区分是否是不可读的部分
    public int currency;
    public boolean unreadble;
    public boolean isVip;

    //用于记录失败的次数，失败三次就不再请求下载
//    public int failedCount;
    //用于记录是否下载成功
//    public boolean isDownloadSuccess;
    //保存当前对象的卷的目录数
    public int volumeSort;
    //标记当前的章节是否是选中阅读的标记为橘黄色,不记录到数据库减少遍历读写次数
    public boolean isCurrentChapterChosen;
    //保存分页的下标格式为[页码,本页开始位置，本页结束位置] [1,10,20];[2,20,30]; 最终改为json格式
    public String pageIndexString;

    //新增保存当前的章节是否为VIP
    //0，免费；1，付费章节。如果为付费章节，文章内容则不全
    public int vipChapter;

    public long getChapterId() {
        return chapterId;
    }

    public void setChapterId(long chapterId) {
        this.chapterId = chapterId;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public int getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(int volumeId) {
        this.volumeId = volumeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public boolean isCached() {
        return isCached;
    }

    public void setCached(boolean cached) {
        isCached = cached;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isLastItem() {
        return isLastItem;
    }

    public void setLastItem(boolean lastItem) {
        isLastItem = lastItem;
    }

    public boolean isReaded() {
        return isReaded;
    }

    public void setReaded(boolean readed) {
        isReaded = readed;
    }

    public long getCurrentChapterId() {
        return currentChapterId;
    }

    public void setCurrentChapterId(long currentChapterId) {
        this.currentChapterId = currentChapterId;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public boolean isUnreadble() {
        return unreadble;
    }

    public void setUnreadble(boolean unreadble) {
        this.unreadble = unreadble;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public int getVolumeSort() {
        return volumeSort;
    }

    public void setVolumeSort(int volumeSort) {
        this.volumeSort = volumeSort;
    }

    public boolean isCurrentChapterChosen() {
        return isCurrentChapterChosen;
    }

    public void setCurrentChapterChosen(boolean currentChapterChosen) {
        isCurrentChapterChosen = currentChapterChosen;
    }

    public String getPageIndexString() {
        return pageIndexString;
    }

    public void setPageIndexString(String pageIndexString) {
        this.pageIndexString = pageIndexString;
    }

    public int getVipChapter() {
        return vipChapter;
    }

    public void setVipChapter(int vipChapter) {
        this.vipChapter = vipChapter;
    }

    //标记不能点击
    public boolean isClick;
}
