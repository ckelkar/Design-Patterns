package wordCount.treesForStrings;



public class Node {
	
	public Node right;
	public Node left;
	public Node parent;
	public String nodecontent;
	public int count;
	

		public Node(String nodecontentIn){
			right=null;
			left=null;
			nodecontent=nodecontentIn;
			count=1;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + count;
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((nodecontent == null) ? 0 : nodecontent.hashCode());
			result = prime * result + ((parent == null) ? 0 : parent.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (count != other.count)
				return false;
			if (left == null) {
				if (other.left != null)
					return false;
			} else if (!left.equals(other.left))
				return false;
			if (nodecontent == null) {
				if (other.nodecontent != null)
					return false;
			} else if (!nodecontent.equals(other.nodecontent))
				return false;
			if (parent == null) {
				if (other.parent != null)
					return false;
			} else if (!parent.equals(other.parent))
				return false;
			if (right == null) {
				if (other.right != null)
					return false;
			} else if (!right.equals(other.right))
				return false;
			return true;
		}
}
