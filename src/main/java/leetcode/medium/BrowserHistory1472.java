package leetcode.medium;

import java.util.LinkedList;

/**
 * ����һ��ֻ֧�ֵ�����ǩҳ�� �����?���ʼ���������ҳ��?homepage?������Է�����������վ?url?��
 * Ҳ�����������ʷ�к���?steps?����ǰ��?steps?����
 * <p>
 * ����ʵ��?BrowserHistory �ࣺ
 * <p>
 * BrowserHistory(string homepage)?����?homepage?��ʼ��������ࡣ
 * void visit(string url)?�ӵ�ǰҳ��ת���� url ��Ӧ��ҳ��??��ִ�д˲�����������ʷǰ���ļ�¼ȫ��ɾ����
 * string back(int steps)?�������ʷ�к���?steps?���������ֻ���������ʷ�к�������?x ����?steps > x?����ô��ֻ����?x?����
 * �뷵�غ��� ���� steps?���Ժ��?url?��
 * string forward(int steps)?�������ʷ��ǰ��?steps?���������ֻ���������ʷ��ǰ������?x?����?steps > x?��
 * ��ô��ֻǰ�� x?�����뷵��ǰ��?����?steps���Ժ�� url?��
 * <p>
 */
public class BrowserHistory1472 {
    private int urlIndex = 0;

    private int urlSize = 0;

    private LinkedList<String> urlList;

    public BrowserHistory1472(String homepage) {
        urlList = new LinkedList();
        urlList.add(homepage);
        urlSize = 1;
    }

    public void visit(String url) {
        urlSize = ++urlIndex + 1;
        urlList.add(urlIndex, url);
    }

    public String back(int steps) {
        if ((urlIndex + 1) > steps) {
            int temp = urlIndex - steps;
            urlIndex = temp;
            return urlList.get(temp);
        } else {
            urlIndex = 0;
            return urlList.get(0);
        }
    }

    public String forward(int steps) {
        if ((urlIndex + steps) < urlSize) {
            int temp = urlIndex + steps;
            urlIndex = temp;
            return urlList.get(temp);
        } else {
            urlIndex = urlSize - 1;
            return urlList.get(urlSize - 1);
        }
    }
}


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */