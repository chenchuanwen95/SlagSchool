package cn.ccw.slagschool.vo;

/**
 * Created by 陈传稳_95 on 2016/3/21.
 */
public class SchoolInfo {
    private String schoolName ;   //学校名称
    private String address ;     //学校地址
    private String isNotional ;  //是国办还是民办的
    private String isDegree ;   //专科还是本科
    private String score ;      //分数
    private String prepareNumber ; // 准备招多少人
    private String remainNumber ;  //剩下多少名额
    private String cutTime ;      // 报名截止时间
    private boolean isConfirm ;    //是否已经印证
    private String foundedTime ;  //学校创办时间

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsNotional() {
        return isNotional;
    }

    public void setIsNotional(String isNotional) {
        this.isNotional = isNotional;
    }

    public String getIsDegree() {
        return isDegree;
    }

    public void setIsDegree(String isDegree) {
        this.isDegree = isDegree;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPrepareNumber() {
        return prepareNumber;
    }

    public void setPrepareNumber(String prepareNumber) {
        this.prepareNumber = prepareNumber;
    }

    public String getRemainNumber() {
        return remainNumber;
    }

    public void setRemainNumber(String remainNumber) {
        this.remainNumber = remainNumber;
    }

    public String getCutTime() {
        return cutTime;
    }

    public void setCutTime(String cutTime) {
        this.cutTime = cutTime;
    }

    public boolean getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(boolean isConfirm) {
        this.isConfirm = isConfirm;
    }

    public String getFoundedTime() {
        return foundedTime;
    }

    public void setFoundedTime(String foundedTime) {
        this.foundedTime = foundedTime;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "schoolName='" + schoolName + '\'' +
                ", address='" + address + '\'' +
                ", isNotional='" + isNotional + '\'' +
                ", isDegree='" + isDegree + '\'' +
                ", score='" + score + '\'' +
                ", prepareNumber='" + prepareNumber + '\'' +
                ", remainNumber='" + remainNumber + '\'' +
                ", cutTime='" + cutTime + '\'' +
                ", isConfirm='" + isConfirm + '\'' +
                ", foundedTime='" + foundedTime + '\'' +
                '}';
    }
}
