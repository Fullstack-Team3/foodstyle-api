/* 
Parse a json file of the trending foods
and display them in the "hot section"
*/
const hot_foods = [
    {
        id: 1,
        name: "Lunch Combo",
        price: "16",
        currency: "USD",
        description: "2 Large hamburgers, 2 medium fries, 2 drumsticks, 1 large coke",
        image_src: "images/food_1.png"
    },
    {
        id: 2,
        name: "Saled",
        price: "12",
        currency: "USD",
        description: "Contains avacodos, cucumbers, and a variety of fresh fruits",
        image_src: "images/food_2.jpg"
    },
    {
        id: 3,
        name: "Steak and potatoes",
        price: "25",
        currency: "USD",
        description: "Staek with some garnishes and potatoes",
        image_src: "images/food_3.jpg"
    },
    {
        id: 4,
        name: "Steak and potatoes",
        price: "25",
        currency: "USD",
        description: "Staek with some garnishes and potatoes",
        image_src: "images/food_3.jpg"
    },
    {
        id: 5,
        name: "Steak and potatoes",
        price: "25",
        currency: "USD",
        description: "Staek with some garnishes and potatoes",
        image_src: "images/food_3.jpg"
    }
]


function food_template(obj){
    return (
        `
        <li>
            <div class="left"><img src=${obj.image_src} alt=""></div>
            <div class="right">
                <p>${obj.name}</p>
                <p>Price <span>$<span>${obj.price}</span></span>
                <p>${obj.description}</p>
                </p>
            </div>
        </li>
        `
    )
}


document.getElementById("hot_items").innerHTML = `${hot_foods.map(food_template).join("")}`
