package com.example.retrofitdemo;

import java.util.List;

/**
 * Create by 张瀛煜 on 2020-05-07 ：）
 */
public class Bean {

    /**
     * ROWS_DETAIL : [{"id":1,"time":"2017-04-02 14:55:23","infoid":"10101"},{"id":2,"time":"2017-05-02 16:44:11","infoid":"10201"},{"id":3,"time":"2017-04-07 11:15:23","infoid":"10301"},{"id":4,"time":"2017-07-02 14:55:23","infoid":"10401"},{"id":5,"time":"2017-05-22 19:35:23","infoid":"10501"},{"id":6,"time":"2017-09-02 09:55:23","infoid":"10601"},{"id":7,"time":"2017-01-02 01:55:23","infoid":"10701"},{"id":8,"time":"2017-09-02 19:55:23","infoid":"10801"},{"id":9,"time":"2017-04-02 14:55:23","infoid":"10901"},{"id":10,"time":"2018-02-02 14:25:13","infoid":"10102"}]
     * RESULT : S
     */

    private String RESULT;
    private List<ROWSDETAILBean> ROWS_DETAIL;

    @Override
    public String toString() {
        return "Bean{" +
                "RESULT='" + RESULT + '\'' +
                ", ROWS_DETAIL=" + ROWS_DETAIL +
                '}';
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public List<ROWSDETAILBean> getROWS_DETAIL() {
        return ROWS_DETAIL;
    }

    public void setROWS_DETAIL(List<ROWSDETAILBean> ROWS_DETAIL) {
        this.ROWS_DETAIL = ROWS_DETAIL;
    }

    public static class ROWSDETAILBean {
        /**
         * id : 1
         * time : 2017-04-02 14:55:23
         * infoid : 10101
         */

        private int id;
        private String time;
        private String infoid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getInfoid() {
            return infoid;
        }

        public void setInfoid(String infoid) {
            this.infoid = infoid;
        }
    }
}
