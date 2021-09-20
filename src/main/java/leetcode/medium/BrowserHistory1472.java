package leetcode.medium;

import java.util.LinkedList;

/**
 * 你有一个只支持单个标签页的 浏览器?，最开始你浏览的网页是?homepage?，你可以访问其他的网站?url?，
 * 也可以在浏览历史中后退?steps?步或前进?steps?步。
 * <p>
 * 请你实现?BrowserHistory 类：
 * <p>
 * BrowserHistory(string homepage)?，用?homepage?初始化浏览器类。
 * void visit(string url)?从当前页跳转访问 url 对应的页面??。执行此操作会把浏览历史前进的记录全部删除。
 * string back(int steps)?在浏览历史中后退?steps?步。如果你只能在浏览历史中后退至多?x 步且?steps > x?，那么你只后退?x?步。
 * 请返回后退 至多 steps?步以后的?url?。
 * string forward(int steps)?在浏览历史中前进?steps?步。如果你只能在浏览历史中前进至多?x?步且?steps > x?，
 * 那么你只前进 x?步。请返回前进?至多?steps步以后的 url?。
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