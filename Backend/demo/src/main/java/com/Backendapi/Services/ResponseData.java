package com.Backendapi.Services;

import java.util.List;

public class ResponseData {
    private Pagination pagination;
    private List<Movie> data;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }



    public static class Pagination {
        private int last_visible_page;
        private boolean has_next_page;
        private int current_page;
        private Items items;


        public int getLast_visible_page() {
            return last_visible_page;
        }

        public void setLast_visible_page(int last_visible_page) {
            this.last_visible_page = last_visible_page;
        }

        public boolean isHas_next_page() {
            return has_next_page;
        }

        public void setHas_next_page(boolean has_next_page) {
            this.has_next_page = has_next_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public Items getItems() {
            return items;
        }

        public void setItems(Items items) {
            this.items = items;
        }

        public static class Items {
            private int count;
            private int total;
            private int per_page;


            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPer_page() {
                return per_page;
            }

            public void setPer_page(int per_page) {
                this.per_page = per_page;
            }
        }


    }

    public static class Movie {
        private int mal_id;
        private String title;
        private Images images;
        private double score;


        public int getMal_id() {
            return mal_id;
        }

        public void setMal_id(int mal_id) {
            this.mal_id = mal_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Images getImages() {
            return images;
        }

        public void setImages(Images images) {
            this.images = images;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public static class Images {
            private Jpg jpg;


            public Jpg getJpg() {
                return jpg;
            }

            public void setJpg(Jpg jpg) {
                this.jpg = jpg;
            }

            public static class Jpg {
                private String image_url;


                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }
            }
        }
    }
}

