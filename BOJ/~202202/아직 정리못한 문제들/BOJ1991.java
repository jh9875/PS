import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		char name;
		Node left;
		Node right;
		Node(char name) {
			this.name =name;
			this.left =null;
			this.right =null;
		}
		Node(char name, Node left, Node right) {
			this.name =name;
			this.left =left;
			this.right =right;
		}
	}
	static class Tree {
		Node root;

		Tree() {
			root =new Node('A');
		}

		void addChild(Node node, char name, char leftChild, char rightChild) {
			if(node ==null) return;

			if(node.name ==name) {
				if(leftChild !='.') node.left =new Node(leftChild);
				if(rightChild !='.') node.right =new Node(rightChild);
			}else {
				addChild(node.left, name, leftChild, rightChild);
				addChild(node.right, name, leftChild, rightChild);
			}
		}

		String preorder() {
			StringBuilder sb =new StringBuilder();
			preorder(root, sb);
			return sb.toString();
		}
		void preorder(Node node, StringBuilder sb) {
			if(node ==null) return;

			sb.append(node.name);
			preorder(node.left, sb);
			preorder(node.right, sb);
		}
		String inorder() {
			StringBuilder sb =new StringBuilder();
			inorder(root, sb);
			return sb.toString();
		}
		void inorder(Node node, StringBuilder sb) {
			if(node ==null) return;

			inorder(node.left, sb);
			sb.append(node.name);
			inorder(node.right, sb);
		}
		String postorder() {
			StringBuilder sb =new StringBuilder();
			postorder(root, sb);
			return sb.toString();
		}
		void postorder(Node node, StringBuilder sb) {
			if(node ==null) return;

			postorder(node.left, sb);
			postorder(node.right, sb);
			sb.append(node.name);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Tree tree =new Tree();
		int N;

		N =Integer.parseInt(br.readLine());
		while(N-->0) {
			st =new StringTokenizer(br.readLine());
			char name =st.nextToken().charAt(0);
			char leftChild =st.nextToken().charAt(0);
			char rightChild =st.nextToken().charAt(0);
			tree.addChild(tree.root, name, leftChild, rightChild);
		}

		bw.write(tree.preorder() +"\n");
		bw.write(tree.inorder() +"\n");
		bw.write(tree.postorder() +"\n");
		bw.flush();
	}
}
