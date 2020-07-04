/**
 <li>
     <div class="img"><img src="images/food_1.png" alt=""></div>
     <div class="text1">
         <p>Food Name Food Name Food Name</p>
         <p>description</p>
     </div>
     <div class="price">
         <p class="price_num">
             <span>$</span>
             <span>29</span>
         </p>
         <p><a href="food_detail.html">view detail</a></p>
     </div>
 </li>
 */
function generateLi(obj, restaurantName) {
    var li = $('<li></li>');
    var div_1 = $('<div class="img"></div>');
    var img = $('<img src=""/>');
    img.attr('src', obj.photo);
    img.appendTo(div_1);

    var div_2 = $('<div class="text1"></div>');
    var p_name = $('<p></p>');
    if (restaurantName){
        p_name.html(obj.name.replace(restaurantName.toUpperCase(),'<span style="color:red">'+ restaurantName.toUpperCase() +'</span>').replace(restaurantName.toLowerCase(),'<span style="color:red">'+ restaurantName.toLowerCase() +'</span>'));
    }else {
        p_name.text(obj.name);
    }
    var p_des = $('<p>'+ obj.description +'</p>');
    p_name.appendTo(div_2);
    p_des.appendTo(div_2);

    var div_3 = $('<div class="price"></div>');
    var p_price = $('<p class="price_num"><span>$</span><span>29</span></p>');
    var p_detail = $('<p></p>');
    var a_detail = $('<a class="btn btn-primary">Add to Cart</a>');
    a_detail.appendTo(p_detail);
    p_price.appendTo(div_3);
    p_detail.appendTo(div_3);

    div_1.appendTo(li);
    div_2.appendTo(li);
    div_3.appendTo(li);

    return li;
}

function loadData(){
    var urlParams = new URLSearchParams(location.search);
    var id = urlParams.get('id');
    var restaurantName = urlParams.get('restaurantName');
    $('#restaurantName').text(restaurantName);
    $.ajax({
        type: "get",
        url: "http://localhost:8080/food/restaurant/"+id,
        async: true,
        contentType: 'application/json',
        dataType: 'JSON',
        success: function(data) {
            var root = $('#food_list');
            root.html("");
            var ul = $('<ul></ul>');
            $.each(data, function (i, obj) {

                generateLi(obj).appendTo(ul)

            });
            ul.appendTo(root);
        }
    })
}

function searchFood() {
    var restaurantName = $('#searchValue').val();
    if (restaurantName.trim() == ''){
        return;
    }
    $.ajax({
        type: "get",
        url: "http://localhost:8080/restaurants/"+ restaurantCategory +"/"+ restaurantName,
        async: true,
        contentType: 'application/json',
        dataType: 'JSON',
        success: function(data) {
            var root = $('#popularity');
            root.html("");
            var row;
            var index = 0;
            $.each(data, function (i, obj) {
                if (i % 4 == 0){
                    row = generateRow();
                }
                generateDiv(obj, restaurantName).appendTo(row)
                if (i % 3 == 0){
                    row.appendTo(root);
                }
                index = i;
            });
            if(index%3 != 0){
                row.appendTo(root);
            }
        }
    });
}