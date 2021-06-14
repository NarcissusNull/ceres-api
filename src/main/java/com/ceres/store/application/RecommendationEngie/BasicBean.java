package com.ceres.store.application.RecommendationEngie;

import java.util.ArrayList;
import java.util.List;

    public class BasicBean {
        private List<String> parameters;
        private boolean tableHead;

        public BasicBean(boolean head) {
            parameters = new ArrayList<String>();
            this.tableHead = head;
        }

        public BasicBean(String... strings) {
            this(false, strings);
        }

        public BasicBean(boolean head, String... strings) {
            parameters = new ArrayList<String>();
            for(String string : strings) {
                parameters.add(string);
            }
            this.tableHead = head;
        }

        public int add(String param) {
            parameters.add(param);
            return this.getSize();
        }

        public boolean set(int index, String param) {
            if(index < this.getSize())
                parameters.set(index, param);
            else
                return false;
            return true;
        }

        public boolean isHead() {
            return tableHead;
        }

        public String toString() {
            StringBuilder str = new StringBuilder(" ");
            int len = 1;
            for (String string : parameters) {
                str.append("\t|" + string);
                if(len++ % 20 == 0)
                    str.append("\n");
            }
            return str.toString();
        }

        public int getSize() {
            return parameters.size();
        }

        public List<String> getArray() {
            return this.parameters;
        }

        public int getId() {
            return this.getInt(0);
        }

        public String getString(int index) {
            return parameters.get(index);
        }

        public int getInt(int index) {
            return Integer.valueOf(parameters.get(index));
        }

        public boolean getBoolean(int index) {
            return Boolean.valueOf(parameters.get(index));
        }

        public float getFloat(int index) {
            return Float.valueOf(parameters.get(index));
        }
    }