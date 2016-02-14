<section id="addbook" class="book-form">
    <form action="<c:url value='/admin/addbook'/>" method="post" class="basic-grey">
        <h1>Add a new Book
            <span>Please fill all the texts in the fields.</span>
        </h1>
        <label>
            <span>Title :</span>
            <input id="title" type="text" name="title" placeholder="Title"/>
        </label>
        <label>
            <span>Author :</span>
            <input id="author" type="text" name="author" placeholder="Author"/>
        </label>
        <label>
            <span>Language :</span>
            <input id="language" type="text" name="language" placeholder="Language"/>
        </label>
        <label>
            <span>Publisher :</span>
            <input id="publisher" type="text" name="publisher" placeholder="Publisher"/>
        </label>
        <label>
            <span>Format :</span>
            <input id="format" type="text" name="format" placeholder="Format"/>
        </label>
        <label>
            <span>ISBN :</span>
            <input id="isbn" type="text" name="isbn" placeholder="ISBN"/>
        </label>
        <label>
            <span>Pages :</span>
            <input id="pages" type="text" name="pages" placeholder="Pages"/>
        </label>
        <label>
            <span>Prise :</span>
            <input id="price" type="text" name="price" placeholder="Price"/>
        </label>
        <label>
            <span>Quantity :</span>
            <input id="quantity" type="text" name="quantity" placeholder="Quantity"/>
        </label>
        <label>
            <span>Category :</span>
            <select name="selection">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </label>
        <label>
            <span>Release Date :</span>
            <input id="releasedate" type="month" name="releasedate" placeholder="Release Date"/>
        </label>
        <label>
            <span>Description :</span>
            <textarea id="description" name="description" placeholder="Description"></textarea>
        </label>
        <label>
            <span>&nbsp;</span>
            <input type="submit" class="button" value="Add"/>
        </label>
    </form>
</section>
