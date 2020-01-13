package com.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "prodcat", joinColumns = {@JoinColumn(name = "product_id")}, inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories = new HashSet<Category>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "productimage", joinColumns = {@JoinColumn(name = "product_id")}, inverseJoinColumns = {@JoinColumn(name = "image_id")})
    private Set<Images> images = new HashSet<>();

    public String getImage() {
        String image = null;
        if (getImages().iterator().hasNext()) {
            image = getImages().iterator().next().getImage();
        }
        return image;
    }

    public String getCategory() {
        return getCategories().iterator().next().getCategory();
    }


    public Product(String name, String description, int price, Set<Category> categories, Set<Images> images) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = categories;
        this.images = images;
    }

    public Set<Images> getImages() {
        return images;
    }

    public void setImages(Set<Images> images) {
        this.images = images;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addCategories(Category category) {
        this.categories.add(category);
    }

    public void addImages(Images image) {
        this.images.add(image);
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
