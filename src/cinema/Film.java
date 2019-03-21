package cinema;

public class Film {
    private String title;
    private String theatre;
    private int duration;
    private String time;
    private String rating;
    private int seatsLeft;
    private String price;

    public void updateSeats(int numOfSeats) {
        setSeatsLeft(getSeatsLeft() - numOfSeats);
    }

    public Film(String t, String th, int dur, String ti, String rat, int seats, String pri) {
        title = t;
        theatre = th;
        duration = dur;
        time = ti;
        rating = rat;
        seatsLeft = seats;
        price = pri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
