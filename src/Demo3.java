import sun.management.counter.perf.PerfInstrumentation;
import javax.swing.*;
///////////////////////////////////// 【类关联、多对多映射】权限、角色与用户

//用户类
class Member {
    private long mID;
    private String name;
    private Role roles[];  //一个用户有多个角色  多对多

    public Member(long mID, String name) {
        this.mID = mID;
        this.name = name;
    }

    public void setRoles(Role roles[]) {
        this.roles = roles;
    }

    public Role[] getRoles() {
        return this.roles;
    }

    public String getInfo() {
        return "【用户信息】用户编号：" + this.mID + " ，用户姓名：" + this.name;
    }
}

//角色类
class Role {
    private long rID;
    private String title;
    private Member members[];    //一个角色有多个用户  多对多
    private Privilege privileges[]; //一个角色有多种权限 一对多

    public Role(long rID, String title) {
        this.rID = rID;
        this.title = title;
    }

    public void setPrivileges(Privilege privileges[]) {
        this.privileges = privileges;
    }

    public Privilege[] getPrivileges() {
        return this.privileges;
    }

    public void setMembers(Member members[]) {
        this.members = members;
    }

    public Member[] getMembers() {
        return this.members;
    }

    public String getInfo() {
        return "【角色信息】角色编号：" + this.rID + " ，角色名称：" + this.title;
    }
}

//权限类
class Privilege {
    private long pID;
    private String title;
    private Role role;  //一种权限对应一种角色

    public Privilege(long pID, String title) {
        this.pID = pID;
        this.title = title;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return this.role;
    }

    public String getInfo() {
        return "【权限信息】权限编号：" + this.pID + " ,权限名称：" + this.title;
    }
}

class Test {
    public static void main(String[] args) {
        Member memberA = new Member(100L, "Rob");
        Member memberB = new Member(128L, "John");
        Member memberC = new Member(192L, "Sansa");
        Role roleA = new Role(1L, "管理员");
        Role roleB = new Role(2L, "公司员工");
        Role roleC = new Role(9999L, "用户");
        Privilege privilegeA = new Privilege(101, "增添数据");
        Privilege privilegeB = new Privilege(102, "删除数据");
        Privilege privilegeC = new Privilege(103, "备份数据");
        Privilege privilegeD = new Privilege(201, "使用系统登陆");
        Privilege privilegeE = new Privilege(202, "打卡");
        Privilege privilegeF = new Privilege(301, "权限1");
        Privilege privilegeG = new Privilege(302, "权限2");
        Privilege privilegeH = new Privilege(303, "权限3");
        //用户与角色
        memberA.setRoles(new Role[]{roleA, roleB, roleC});
        memberB.setRoles(new Role[]{roleB, roleC});
        memberC.setRoles(new Role[]{roleC});
        roleA.setMembers(new Member[]{memberA});
        roleB.setMembers(new Member[]{memberA, memberB});
        roleC.setMembers(new Member[]{memberA, memberB, memberC});
        //角色与权限
        roleA.setPrivileges(new Privilege[]{privilegeA, privilegeB, privilegeC});
        roleB.setPrivileges(new Privilege[]{privilegeD, privilegeE});
        roleC.setPrivileges(new Privilege[]{privilegeF, privilegeG, privilegeH});
        privilegeA.setRole(roleA);
        privilegeB.setRole(roleA);
        privilegeC.setRole(roleA);
        privilegeD.setRole(roleB);
        privilegeE.setRole(roleB);
        privilegeF.setRole(roleC);
        privilegeG.setRole(roleC);
        privilegeH.setRole(roleC);

        System.out.println("=========== 通过用户查找信息 ============");
        System.out.println(memberA.getInfo());    //用户A个人信息
        for (int x=0;x<memberA.getRoles().length;x++){
            System.out.println("\t|-"+memberA.getRoles() [x].getInfo()); //用户A对应的角色信息
            for (int y=0;y<memberA.getRoles()[x].getPrivileges().length;y++){
                System.out.println("\t\t|-"+memberA.getRoles()[x].getPrivileges()[y].getInfo()); //各角色的权限信息
            }
        }
        System.out.println("=========== 通过角色查找信息 ============");
        System.out.println(roleA.getInfo());
        System.out.println("\t|-获取此角色下的权限信息");
        for(int i=0;i<roleA.getPrivileges().length;i++){
            System.out.println("\t\t|-"+roleA.getPrivileges()[i].getInfo());
        }
        System.out.println("\t|获取此角色下的用户信息");
        for(int i=0;i<roleA.getMembers().length;i++){
            System.out.println("\t\t|-"+roleA.getMembers()[i].getInfo());
        }
        System.out.println("=========== 通过权限获取用户信息 ============");
        System.out.println(privilegeA.getInfo());
        for(int i=0;i<privilegeA.getRole().getMembers().length;i++){
            System.out.println("\t|-"+privilegeA.getRole().getMembers()[i].getInfo());
        }
        System.out.println(privilegeD.getInfo());
        for(int i=0;i<privilegeD.getRole().getMembers().length;i++){
            System.out.println("\t|-"+privilegeD.getRole().getMembers()[i].getInfo());
        }

    }

}
