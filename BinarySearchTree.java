// Adam Chin CHNADA002
// 2017-04-02
// CSC2001F Assignment 1 2017

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BinarySearchTree {

    public BinaryTreeNode root;

    public BinarySearchTree populate() throws IOException {
        BinarySearchTree bst = new BinarySearchTree();

        try (BufferedReader br = new BufferedReader(new FileReader("testdata.txt"))) { 
            String line;

            ArrayList<Person> personArray = new ArrayList<Person>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                Person p = new Person(null, null, null);
                p.name = parts[2];
                p.number = parts[1];
                p.adress = parts[0];
                personArray.add(p);

            }

            for (int i = 0; i < personArray.size(); i++) { 
                bst.insert(personArray.get(i));
            }

        }
        return bst;
    }

    public void insert(Person per) {
        BinaryTreeNode node = new BinaryTreeNode(per);
        node.p = per;
        if (root == null) {
            root = node;
            return;
        }
        insertRec(root, node);
    }

    private void insertRec(BinaryTreeNode newNode, BinaryTreeNode exsistingNode) {

        Person beingAdded = newNode.p;
        Person AddedTo = exsistingNode.p;
        if ((beingAdded.name).compareTo(AddedTo.name) > 0) {
            if (newNode.left == null) {
                newNode.left = exsistingNode;
            } else {
                insertRec(newNode.left, exsistingNode);
            }
        } else if (newNode.right == null) {
            newNode.right = exsistingNode;
        } else {
            insertRec(newNode.right, exsistingNode);
        }
    }

    public void visit(BinaryTreeNode node) { 

        System.out.println(node.p.toString());
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            visit(node);
            inOrder(node.getRight());
        }
    }

    public void find(String s) {
        if (root == null) {
        } else {
            find(s, root);
        }
    }

    public void find(String s, BinaryTreeNode node) {
        boolean found = false;
        
        if (s.equals(node.p.name)) {
            found = true;
            System.out.println(node.p.toString());      
        }
        
        if (found == false) { 
            if (node.p.name.compareTo(s) > 0) {
                if (node.left != null) {
                    find(s, node.left);
                }
                else{System.out.println("Not Found: " + s);}
            }   
            else {
                if (node.right != null) {                       
                find(s, node.right);
                }
                else{System.out.println("Not Found: " + s);}
                    
                }
            }
        }
    }

