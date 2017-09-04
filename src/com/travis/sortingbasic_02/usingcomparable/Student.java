package com.travis.sortingbasic_02.usingcomparable;

/**
 * 用于测试自定义类型排序
 */
public class Student implements Comparable<Student> {

    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 先通过分数对比，分数高的排前面，分数相同则通过名字排序
     * @param that 另一个Student对象
     * @return
     */
    @Override
    public int compareTo(Student that) {

        // this.score大于that.score 返回 -1 小于返回 1 否则 根据名字排序
        if(this.score.compareTo(that.getScore()) > 0){
            return -1;
        }else if (this.score.compareTo(that.getScore()) < 0){
            return 1;
        }else {  //this.score == that.sore
            return this.name.compareTo(that.getName());
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
