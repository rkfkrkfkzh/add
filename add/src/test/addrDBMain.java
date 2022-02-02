package test;

import java.util.ArrayList;
import java.util.Scanner;

import service.ServiceImpl;
import vo.Member;

public class addrDBMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceImpl service = new ServiceImpl();
		boolean flag = true, flag2 = false;
		int menu, i;
		String name = null, tel = null, address = null;
		ArrayList<Member> list = null;
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("1.�߰� 2.��ü�˻� 3.�˻�  4.���� 5.���� 6.����");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.print("�̸�:");
				name = sc.next();
				System.out.print("��ȭ:");
				tel = sc.next();
				sc.nextLine();
				System.out.print("�ּ�:");
				address = sc.nextLine();
				Member m = new Member(name, tel, address);
				service.addMember(m);
				break;
			case 2:
				list = service.getMembers();
				for (i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
				break;
			case 3:
				System.out.print("�˻��� ����� �̸�:");
				name = sc.next();
				Member m2 = service.getMember(name);
				if (m2 == null) {
					System.out.println("�˻��� ����� ����.");
				} else {
					System.out.println(m2);
				}
				break;
			case 4:
				flag = false;
				break;
			case 5:
				System.out.print("������ ����� �̸�:");
				name = sc.next();
				System.out.print("������ ��ȭ:");
				tel = sc.next();
				sc.nextLine();
				System.out.print("������ �ּ�:");
				address = sc.nextLine();
				Member m3 = new Member(name, tel, address);
				flag2 = service.editMember(m3);
				if (flag2) {
					System.out.println("����ó�� �Ǿ����ϴ�.");
				} else {
					System.out.println("ó������ �ʾҽ��ϴ�.");
				}
				break;
			case 6:
				System.out.print("������ ����� �̸�:");
				name = sc.next();
				flag2 = service.delMember(name);
				if (flag2) {
					System.out.println("����ó�� �Ǿ����ϴ�.");
				} else {
					System.out.println("ó������ �ʾҽ��ϴ�.");
				}
				break;
			default:
				System.out.println("�߸��Է�");
			}
		}
		
		sc.close();
	}
}
