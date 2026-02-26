class node{
    int data;
    node left;
    node right;
    node(int data){
        this.data=data;
    }
}
public class BST{
    node root;
    node insert(node root,int data){
        if(root==null){
            root= new node(data);
            return root;
        }
        if(data<root.data){
            root.left=insert(root.left,data);
            return root;
        }
        else if(data>root.data){
            root.right=insert(root.right,data);
            return root;
        }
        return root;
    }
    void inorder(node root){
        if(root==null) return ;
        inorder(root.left);
        System.out.println(root.data+"->");
        inorder(root.right);
    }
    void preorder(node root){
        if(root == null) return ;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    node delete(node root,int data){
        if(root==null) return null;
        else if(data<root.data){
            root.left=delete(root.left, data);
        }
        else if(data>root.data){
            root.right=delete(root.right, data);
        }
        else{
            if(root.left==null&&root.right==null){
                return null;
            }
            else if(root.left==null){
                return root.right;

            }
            else if(root.right==null){
                return root.left;

            }
            node sucssesor = findMin(root.right);
            root.data=sucssesor.data;
            root.right =delete(root.right, sucssesor.data);
            
        }
        return root;
    }
        node findMin(node root){
            while(root.left!=null) root=root.left;
            return root;
        }
    
    public static void main(String[] args) {
        BST obj = new BST();
        obj.root = obj.insert(obj.root,10);
        obj.insert(obj.root,20);
        obj.insert(obj.root,30);
        obj.insert(obj.root,40);
        obj.insert(obj.root,25);
        System.out.println("Inorder traversal after inserting");
        obj.inorder(obj.root);
        System.out.println("Preorder traversal after inserting");
        obj.preorder(obj.root);
        obj.delete(obj.root,25);
        System.out.println("Inorder traversal after deleting");
        obj.inorder(obj.root);
        System.out.println("Preorder traversal after deleting");
        obj.preorder(obj.root);     

    }

}