package com.edu.gupao.vip.pattern.template.course;

/**
 * NetworkCourse类
 * 模板会有一个或多个未实现方法，而且这几个未实现的方法有固定的执行顺序
 * @author wangjixue
 * @date 2019-07-21 22:33
 */
public abstract class NetworkCourse {

   public abstract void checkHomework();

   public final void  createCourse(){
    // 1 . 发布预习资料
        this.postPreResource();
    // 2 . 制作PPT课件
        this.createPPT();
    // 3 . 在线直播
        this.liveVideo();
    // 4 . 提交课件，课堂笔记
        this.postNote();
    // 5 . 提交源码
        this.postSource();
    // 6 . 布置作业，如果有，就检查作业；没有就不检查作业
        if(needHomeWork()){
            checkHomework();
        }
    }
    //钩子方法：实现流程的微调
    public boolean needHomeWork() {
        System.err.println("没有布置了课后作业");
        return false;
    }

    private final void postSource() {
        System.err.println("提交课堂源码");
    }

    private final void postNote() {
        System.err.println("提交课件和笔记");
    }

    private final void liveVideo() {
        System.err.println("线上直播授课");
    }

    private final void createPPT() {
        System.err.println("制作PPT课件");
    }

    private final void postPreResource() {
        System.err.println("发布预习资料");
    }
}
