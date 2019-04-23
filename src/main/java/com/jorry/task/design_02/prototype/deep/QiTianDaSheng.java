package com.jorry.task.design_02.prototype.deep;

import java.io.*;
import java.util.Date;

public class QiTianDaSheng extends Monkey implements Cloneable, Serializable {

    public JinGuBang jinGuBang;

    public QiTianDaSheng() {
        this.jinGuBang = new JinGuBang();
        this.birthday = new Date();
    }

    // 克隆方法，采用的是深克隆
    // 可能会出现单例破坏的问题
    //
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    public Object deepClone() {
        try {

            // 内存中完成操作，对象读写，是通过字节码直接操作
            // 序列化操作
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            // 写入磁盘
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            // 完整的新的对象
            QiTianDaSheng copy = (QiTianDaSheng) ois.readObject();
            copy.birthday = new Date();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public QiTianDaSheng shallowClone(QiTianDaSheng q) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.setAge(q.getAge());
        qiTianDaSheng.setBirthday(q.getBirthday());
        qiTianDaSheng.setHeigth(q.getHeigth());
        qiTianDaSheng.setWidth(q.getWidth());
        qiTianDaSheng.jinGuBang = q.jinGuBang;
        return qiTianDaSheng;
    }
}
