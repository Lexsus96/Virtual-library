package com.mkyong.web.controller;


import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;
/**
 *
 * Created by Alex on 04.07.2016.
 */

@Service
public class jdbcControl {

    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/Library";
    private static final String log = "postgres";
    private static final String pas = "13951";
    private static Connection connection = null;
    private String slog = null;

    private void updateLog(PreparedStatement preparedStatement, String slog, String type) {
        try {
        preparedStatement = connection.prepareStatement(
                "INSERT INTO log (type, value) " +
                        "VALUES (?, ?);");
        preparedStatement.setString(1, type);
        preparedStatement.setString(2, slog);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Log> logs() {
        ArrayList<Log> listLog= new ArrayList<Log>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM log ORDER BY oid DESC" );
            slog = preparedStatement.toString();
            updateLog(preparedStatement, slog, "[INFO]");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Log log = new Log(resultSet.getString(1), resultSet.getString(2));
                listLog.add(log);
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return listLog;
    }
    public void deleteLog() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM log" );
            slog = preparedStatement.toString();
            preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
    }
    public boolean signIn(String login, String pass) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM users WHERE users.login = ? AND users.password = ? ;");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, pass);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            if(resultSet.next())
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }
    public ArrayList<Book> searchAuthor(String request) {
        ArrayList<Book> listbook = new ArrayList<Book>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM books, authors WHERE books.author_id = authors.id AND authors.surname LIKE ? ORDER BY year;");
            preparedStatement.setString(1, request);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            while (resultSet.next()) {
                Author author = new Author(resultSet.getString(7), resultSet.getString(8), resultSet.getString(9));
                Book book = new Book(resultSet.getString(1), resultSet.getString(2), author, resultSet.getString(4));
                listbook.add(book);
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return listbook;
    }

    public ArrayList<Book> searchTitle(String request) {
        ArrayList<Book> listbook = new ArrayList<Book>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM books, authors WHERE books.author_id = authors.id AND books.title LIKE ? ORDER BY year;");
            preparedStatement.setString(1, request);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            while (resultSet.next()) {
                Author author = new Author(resultSet.getString(7), resultSet.getString(8), resultSet.getString(9));
                Book book = new Book(resultSet.getString(1), resultSet.getString(2), author, resultSet.getString(4));
                listbook.add(book);
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return listbook;
    }

    public ArrayList<Book> searchYear(String request) {
        ArrayList<Book> listbook = new ArrayList<Book>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM books, authors WHERE books.author_id = authors.id AND books.year LIKE ? ORDER BY year;");
            preparedStatement.setString(1, request);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            while (resultSet.next()) {
                Author author = new Author(resultSet.getString(7), resultSet.getString(8), resultSet.getString(9));
                Book book = new Book(resultSet.getString(1), resultSet.getString(2), author, resultSet.getString(4));
                listbook.add(book);
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return listbook;
    }
    public ArrayList<Book> allBook() {
        ArrayList<Book> listbook = new ArrayList<Book>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM books, authors " +
                            "WHERE books.author_id = authors.id ORDER BY year;");
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            while (resultSet.next()) {
                Author author = new Author(resultSet.getString(7), resultSet.getString(8), resultSet.getString(9));
                Book book = new Book(resultSet.getString(1), resultSet.getString(2), author, resultSet.getString(4));
                listbook.add(book);
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return listbook;
    }

    public ArrayList<Author> allAuthors() {
        ArrayList<Author> listAuthors = new ArrayList<Author>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM authors;");
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            while (resultSet.next()) {
                Author author = new Author(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                listAuthors.add(author);
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return listAuthors;
    }
    public ArrayList<Book> getBooksOfUSer(String login) {
        ArrayList<Book> list = new ArrayList<Book>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT  authors.id, authors.name, authors.surname, books.title, books.year, books.isbn " +
                            "FROM books, authors, taken_books " +
                            "WHERE author_id = id AND books.isbn = taken_books.isbn AND id_user = ? ;");
            preparedStatement.setString(1, login);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            while (resultSet.next()) {
                Author author = new Author(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                Book book = new Book(resultSet.getString(4), resultSet.getString(5), author, resultSet.getString(6));
                list.add(book);
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return list;
    }

    public ArrayList<User> allUsers() {
        ArrayList<User> listUsers = new ArrayList<User>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM users;");
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            while (resultSet.next()) {
                User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getBoolean(3));
                listUsers.add(user);
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return listUsers;

    }
    public Book getBook(String isbn) {
        Book book = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM books WHERE books.isbn LIKE ?;");
            preparedStatement.setString(1, isbn);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            if(resultSet.next()){
                String s = resultSet.getString(4);
                book = new Book(resultSet.getString(1), resultSet.getString(2), getAuthor(resultSet.getString(3)), s);
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return book;
    }
    public  boolean insertBook(Book book) {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO books (title, year, author_id, isbn) " +
                            "VALUES (?, ?, ?, ?);");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getYear());
            preparedStatement.setString(3, book.getAuthor().getId());
            preparedStatement.setString(4, book.getIsbn());
            slog = preparedStatement.toString();
            preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return true;
    }

    public boolean readBook(String login, String isbn) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO taken_books (isbn, id_user) VALUES (?, ?);");
            preparedStatement.setString(1, isbn);
            preparedStatement.setString(2, login);
            slog = preparedStatement.toString();
            int k = preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
            if(k != 0)
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }
    public boolean backBook(String login, String isbn) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM taken_books WHERE isbn LIKE ? AND id_user LIKE ? ; ");
            preparedStatement.setString(1, isbn);
            preparedStatement.setString(2, login);
            slog = preparedStatement.toString();
            preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return true;
    }

    public  boolean insertAuthor(Author author) {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO authors (id, name, surname) " +
                            "VALUES (?, ?, ?); ");
            preparedStatement.setString(1,author.getId());
            preparedStatement.setString(2,author.getFirst_name());
            preparedStatement.setString(3,author.getSecond_name());
            slog = preparedStatement.toString();
            preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return true;
    }
    public Author getAuthor(String author_id) {
        Author author = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM authors WHERE authors.id LIKE ?;");
            preparedStatement.setString(1, author_id);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
             if(resultSet.next()){
                 author = new Author(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
             }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return author;
    }
    public User getUser(String login) {
        User user = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM users WHERE login LIKE ? ;");
            preparedStatement.setString(1, login);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            if(resultSet.next()){
                user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getBoolean(3));
            }
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return user;
    }
    public  boolean aviableBook(Book book) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT isbn FROM books WHERE books.isbn = ?;");
            preparedStatement.setString(1, book.getIsbn());
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            if(resultSet.next())
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }

    public boolean aviableBook(String isbn) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT isbn FROM books WHERE books.isbn = ?;");
            preparedStatement.setString(1, isbn);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            if(resultSet.next())
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }
    public  boolean aviableAuthor(Author author) {
        String queryAuthor = "SELECT id FROM authors WHERE authors.id = '" + author.getId() + "';";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id FROM authors WHERE authors.id = ?;");
            preparedStatement.setString(1, author.getId());
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            if(resultSet.next())
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }
    public  boolean aviableAuthor(String author_id) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id FROM authors WHERE authors.id = ?;");
            preparedStatement.setString(1, author_id);
            slog = preparedStatement.toString();
            ResultSet resultSet = preparedStatement.executeQuery();
            updateLog(preparedStatement, slog, "[INFO]");
            if(resultSet.next())
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }
    public  boolean deleteBook(Book book) {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM books WHERE isbn = ?;");
            preparedStatement.setString(1,book.getIsbn());
            slog = preparedStatement.toString();
            int k =  preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
            if(k != 0)
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }
    public boolean deleteAuthor(String id) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM authors WHERE id = ?;");
            preparedStatement.setString(1, id);
            slog = preparedStatement.toString();
            int k =  preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
            if(k != 0)
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }

    public boolean deleteUser(String login) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE login = ? ;");
            preparedStatement.setString(1, login);
            slog = preparedStatement.toString();
            int k =  preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
            if(k != 0)
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }

    public  boolean updateBook(Book book) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE books SET title = ?, year = ?, author_id = ?, isbn = ? " +
                            "WHERE isbn = ?;");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getYear());
            preparedStatement.setString(3, book.getAuthor().getId());
            preparedStatement.setString(4,book.getIsbn());
            preparedStatement.setString(5,book.getIsbn());
            slog = preparedStatement.toString();
            int k = preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
            if(k != 0)
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }

    public  boolean updateAuthor(Author author) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE authors SET id = ?, name = ?, surname = ? " +
                            "WHERE id = ?;");
            preparedStatement.setString(2, author.getFirst_name());
            preparedStatement.setString(3, author.getSecond_name());
            preparedStatement.setString(1, author.getId());
            preparedStatement.setString(4, author.getId());
            slog = preparedStatement.toString();
            int k = preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
            if(k != 0)
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }

    public  boolean updateUser(User user) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET login = ?, password = ?, is_admin = ? " +
                            "WHERE login = ?;");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.getAdmin());
            preparedStatement.setString(4, user.getLogin());
            slog = preparedStatement.toString();
            int k = preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
            if(k != 0)
                return true;
        } catch (Exception ex) {
            slog = "[ERROR] " + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return false;
    }

    public boolean insertUser(User user) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, log, pas);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (login, password, is_admin) " +
                            "VALUES (?, ?, ?);");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.getAdmin());
            slog = preparedStatement.toString();
            preparedStatement.executeUpdate();
            updateLog(preparedStatement, slog, "[INFO]");
        } catch (Exception ex) {
            slog = "[ERROR]" + slog;
            System.out.println(slog);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    slog = "connection.close";
                    System.out.println(slog);
                }
            }
        }
        return true;
    }
}


