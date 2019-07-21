package com.edu.gupao.vip.pattern.template.course;

/**
 * BigDataCourse类
 *
 * @author wangjixue
 * @date 2019-07-21 22:56
 */
public  class BigDataCourse extends NetworkCourse{
    private boolean needHomeworkFlag;

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    @Override
    public boolean needHomeWork(){
        return true;
    }
    public void checkHomework() {
        System.err.println("检查大数据的课后作业");
    }
}
