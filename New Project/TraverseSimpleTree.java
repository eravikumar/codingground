
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

public class TraverseSimpleTree  {
  public JTree tree;
  DefaultMutableTreeNode root, n2, n3,n4,n5,n6,n7,n8,n9,n10;
  public TraverseSimpleTree() {
    //root = new DefaultMutableTreeNode("ROOT", true);
    root = new DefaultMutableTreeNode("AND", true);
    n2 = new DefaultMutableTreeNode("EQUALS" , true);
    n3 = new DefaultMutableTreeNode("BRANCH" , true);
    n4 = new DefaultMutableTreeNode("BR" , true);
    n5 = new DefaultMutableTreeNode("EQUALS" , true);
    n6 = new DefaultMutableTreeNode("AMOUNT" , true);
    n7 = new DefaultMutableTreeNode("MINUS" , true);
    n8 = new DefaultMutableTreeNode("1000" , true);
    n9 = new DefaultMutableTreeNode("500" , true);
    n10 = new DefaultMutableTreeNode("200" , true);

    //n1(n2(n3,n4),
    //   n5(n6,
    //		n7(n8,n9,n10)))
    
    root.add(n2); root.add(n5);
    n2.add(n3); n2.add(n4);
    n5.add(n6);n5.add(n7);
    n7.add(n8); n7.add(n9); n7.add(n10);
    
    tree = new JTree(root);
    }

	 public static DefaultMutableTreeNode createOpenTreeNode() {
		 
		 return new DefaultMutableTreeNode("(",false);
	 }
	 public static DefaultMutableTreeNode createCloseTreeNode() {
		 
		 return new DefaultMutableTreeNode(")",false);
	 }
	 public static DefaultMutableTreeNode createSepTreeNode() {
		 
		 return new DefaultMutableTreeNode(",",false);
	 }
	 
	 
	 @SuppressWarnings("unchecked")
	public static List<DefaultMutableTreeNode> getPreorder(DefaultMutableTreeNode rootNode) {
		
		 	List<DefaultMutableTreeNode> list = new ArrayList<DefaultMutableTreeNode>();
		 	Enumeration<DefaultMutableTreeNode> en = rootNode.preorderEnumeration();
		 	while (en.hasMoreElements())
   	  		{
			 	DefaultMutableTreeNode node = en.nextElement();
			 	list.add(node);
   	  		}
		 	return list;
   	     
	 }
	 
	 public static void main(String args[]){
		TraverseSimpleTree a =  new TraverseSimpleTree();
	    TreeModel model = a.tree.getModel();
	    DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) model.getRoot();
		// Just changing enumeration kind here
		//Enumeration<DefaultMutableTreeNode> en =  PreorderEnumeration2.preorderEnumeration(rootNode);
	    List<DefaultMutableTreeNode> list = getPreorder(rootNode);
	    for(DefaultMutableTreeNode node: list) {
	    	if(!node.isLeaf()) {
	    		int count = node.getChildCount();
	    		for(int i=0;i<(2*count-1);i++) {
	    			if(i%2==1) {
	    				node.insert(createSepTreeNode(),i);
	    			}
	    		}
	    		node.insert(createOpenTreeNode(), 0);
	    		node.add(createCloseTreeNode());
	    	}
	    }
	    list = getPreorder(rootNode);
	    for(DefaultMutableTreeNode node: list) {
	    	System.out.print(node.getUserObject());
	    }

	 }
   
  }



