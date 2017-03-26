package com.netcracker.edu.java.tasks;

import java.util.Iterator;

/**
 * Created by Антон on 26.03.2017.
 */
public class TreeNodeImpl implements TreeNode{
    private TreeNode parent;
    private boolean flag;
    Object data;
    @Override
    public TreeNode getParent() {
        return this.parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return null;
    }

    @Override
    public void addChild(TreeNode child) {
        child.setParent(this);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if (!this.equals(child.getParent())) return false;
        child.setParent(null);
        return true;
    }

    @Override
    public boolean isExpanded() {
        return flag;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.flag = expanded;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getTreePath() {
        return null;
    }

    @Override
    public TreeNode findParent(Object data) {
        return null;
    }

    @Override
    public TreeNode findChild(Object data) {
        return null;
    }
}
