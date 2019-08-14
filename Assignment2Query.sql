﻿/*
Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top
*/
SELECT product.ProductId AS "Id",product.ProductName AS "Title",category.CategoryName AS "Category Title",product.Price AS "Price" FROM product,categoryid,category WHERE product.ProductId = categoryid.ProductId AND categoryid.CategoryId = category.CategoryID AND product.Stock > 0 ORDER BY product.ProductId Desc;

/*
Display the list of products which don't have any images
*/
SELECT product.ProductId AS "Id",product.ProductName AS "Title" FROM product WHERE product.ProductId NOT IN(SELECT images.ProductId FROM images);
/*
Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)
*/
SELECT category.CategoryId AS "Id",category.CategoryName AS "Category Title",IF(category.ParentCategoryId > 0,category.CategoryName,"Top Category") AS "Parent Category Title" FROM category ORDER BY "Parent Category Title",category.CategoryName;
/*
Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
*/
SELECT leaf.CategoryId, leaf.CategoryName, parent.CategoryName AS parent_category_name FROM category leaf, category parent WHERE parent.CategoryId = leaf.ParentCategoryId AND NOT EXISTS(SELECT *  FROM category child WHERE leaf.CategoryId = child.ParentCategoryId);
/*
Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
*/
SELECT product.ProductName AS "Name",product.Price AS "Price",product.Description AS "Description" FROM product WHERE product.ProductId IN (SELECT categoryid.ProductId FROM categoryid WHERE categoryid.CategoryId IN (SELECT category.CategoryId FROM category WHERE category.CategoryName = "Xiaomi"));
/*
Display the list of Products whose Quantity on hand (Inventory) is under 50.
*/
SELECT product.ProductId AS "Id",product.ProductName AS "Name" FROM product WHERE product.Stock < 50;
