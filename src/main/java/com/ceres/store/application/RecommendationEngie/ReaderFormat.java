package com.ceres.store.application.RecommendationEngie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReaderFormat {
    List<BasicBean> lists;
    List<HabitsBean> formLists;

    public List<BasicBean> read (String filePath) throws IOException {
        @SuppressWarnings("resource")
        BufferedReader in = new BufferedReader(
                new FileReader(filePath));
        String s;
        BasicBean basicBean = null;
        lists = new ArrayList<BasicBean>();
        while((s = in.readLine()) != null) {
//          System.out.println(s);
            String[] params = s.split("\t");
            basicBean = new BasicBean(params);
            lists.add(basicBean);
        }
        return lists;
    }

    public List<HabitsBean> formateLogUser(String filePath) throws IOException {
        lists = this.read(filePath);
        formLists = new LinkedList<HabitsBean>();
        HabitsBean row = null;
        for (BasicBean basicBean : lists) {
            if(basicBean.isHead()) {
                row = new HabitsBean(1);
                row.setId(basicBean.getInt(0));
                row.add(basicBean.getString(1));
                formLists.add(row);
            } else {
                this.addBinarySerch(formLists, basicBean);
            }
        }
        return formLists;
    }

    private void addBinarySerch(List<HabitsBean> lists, BasicBean bean) {
        int start = 0;
        int end = lists.size()-1;
        int pointer = (start + end + 1) / 2;
        HabitsBean row = lists.get(pointer);
        while(start <= end) {
            if(row.getId() == bean.getId()) {
                row.add(bean.getString(1));
                lists.set(pointer, row);
                return ;
            } else if(start == end) {
                break;
            }else if(row.getId() > bean.getId()) {

                end = pointer;
            } else if(row.getId() < bean.getId()) {
                start = pointer;
            }
            pointer = (start + end + 1) / 2;
            row = lists.get(pointer);
        }
        HabitsBean newBean = new HabitsBean(bean.getId());
        newBean.add(bean.getString(1));
        lists.add(newBean);
        return ;
    }

}