<section id="quotes">
    <div class="quote">
    </div>
</section>

<section class="books">
    <c:forEach var="book" items="${pageOne}">
        <a href="<c:url value='/description'/>?id=${book.id}">
            <div class="book">
                <div class="book-image">
                    <img src="http://place-hold.it/160x240">
                </div>
                <div class="book-title">
                        ${book.name}
                </div>
                <div class="book-author">
                        ${book.author}
                </div>
            </div>
        </a>
    </c:forEach>
</section>

<section class="books">
    <c:forEach var="book" items="${pageTwo}">
        <a href="<c:url value='/description'/>?id=${book.id}">
            <div class="book">
                <div class="book-image">
                    <img src="http://place-hold.it/160x240">
                </div>
                <div class="book-title">
                        ${book.name}
                </div>
                <div class="book-author">
                        ${book.author}
                </div>
            </div>
        </a>
    </c:forEach>
</section>