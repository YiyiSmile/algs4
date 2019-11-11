package algs4.rewrite.linkedlist;

/**
 * @Author totian
 * @Date 2019/11/5 12:24
 * @Version 1.0
 * @Description 链表小练习， 模拟将水浒108将信息加入到链表里边
 */
public class MySingleLinkedList {

    //头节点，只保存链表头，不保存用户数据
    private HeroNode head = new HeroNode(0, "", "");
    //1. 无序加入。新增节点加到链表末尾。另一种需求是有序加入，比如按序号加入。
    public void add(HeroNode node){
        HeroNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }
    //2.有序加入，加入后，编号保持升序。
    public void addByOrder(HeroNode newHero){
        //如果列表为空
        if(head.next == null) {
            add(newHero);
            return;
        }
        //如果列表不为空
        HeroNode current = head.next;
        HeroNode previous = head;
        while(current != null){
            if(current.no > newHero.no){

                break;
            }else if(current.no < newHero.no){
                previous = current;
                current = current.next;
            }else if(current.no == newHero.no){
                System.out.println("已存在相同编号的英雄");
                break;
            }
        }

        previous.next = newHero;
        newHero.next = current;
    }
    //遍历链表
    public void list(){
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        //不为空，遍历链表并打印
        HeroNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        MySingleLinkedList myLinkedList = new MySingleLinkedList();
        myLinkedList.addByOrder(hero2);
        myLinkedList.addByOrder(hero3);
        myLinkedList.addByOrder(hero4);
        myLinkedList.addByOrder(hero1);

        myLinkedList.list();
    }

}



class HeroNode {
    int no;
    private String name;
    private String nickName;
    HeroNode next;

    public HeroNode(int heroNo, String heroName, String heroNickName){
        this.no = heroNo;
        this.name = heroName;
        this.nickName = heroNickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name=' " + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

