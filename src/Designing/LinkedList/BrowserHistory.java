package Designing.LinkedList;

public class BrowserHistory {
    class Node {
        Node front = null;
        Node back = null;
        String data;

        public Node(String data) {
            this.data = data;
        }
    }

    Node currHead;
    public BrowserHistory(String message) {
        currHead = new Node(message);
    }
    public void visit(String url) {
        Node newNode = new Node(url);
        newNode.back = currHead;
        currHead.front = newNode;

        currHead = newNode;
    }
    public Node back(int steps) {
        while (steps > 0 && currHead.back != null) {
            currHead = currHead.back;
            steps--;
        }
        return currHead;
    }
    public Node forward(int steps) {
        while (steps > 0 && currHead.front != null) {
            currHead = currHead.front;
            steps--;
        }
        return currHead;
    }

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("leetcode.com");

        // 2. Visit some new URLs
        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");

        // 3. Go back a couple of steps
        // This should land us on "google.com"
        System.out.println("Going back 2 steps: " + history.back(2).data);

        // 4. Visit a new page. This is the key functionality:
        // Visiting a new page after going back clears the forward history.
        history.visit("linkedin.com");

        // 5. Try to go forward (should only go one step at most to linkedin.com)
        System.out.println("Going forward 5 steps: " + history.forward(5).data);

        // 6. Go back again
        System.out.println("Going back 1 step: " + history.back(1).data);
    }

}
