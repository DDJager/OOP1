/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author Danny
 * @version 11/2/2016
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private int borrow;
    private boolean courseText;
    
    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int pageNumbers, boolean courseTextBool)
    {
        this.author = bookAuthor;
        this.title = bookTitle;
        this.pages = pageNumbers;
        this.refNumber = "";
        this.courseText = courseTextBool;
    }

    public String getAuthor()
    {
        return this.author;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public int getPages()
    {
        return this.pages;
    }
    
    public void printAuthor()
    {
        System.out.println("Author: " + this.author);
    }
    
    public void printTitle()
    {
        System.out.println("Title: " + this.title);
    }
   
    public void printDetails()
    {
        System.out.println("Title: " + this.getTitle());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Pages: " + this.getPages());
        System.out.println(this.printDetailsCheck());
        System.out.println("Amount of times borrowed: " + this.getBorrowed());
    }
    
    public void setRefNumber(String ref)
    {
        if (ref.length() >= 3) { 
            this.refNumber = ref;
        }
    }
    
    public String getRefNumber()
    {
        return this.refNumber;
    }
    
    private String printDetailsCheck()
    {
       if(this.refNumber.length() <= 0) {
           return "Ref Number: ZZZ";
       } else {
           return "Ref Number: " + this.refNumber;
       }
    }
    
    public void borrowBook()
    {
        this.borrow++;
    }
    
    public int getBorrowed()
    {
        return this.borrow;
    }
    
    public void isCourseText(boolean courseTextBool)
    {
        this.courseText = courseTextBool;
    }
}
