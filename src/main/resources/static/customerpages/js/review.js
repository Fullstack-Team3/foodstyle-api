let ratings = ["one", "two", "three", "four", "five"]

ratings.forEach(element => {
    document.getElementById(element).addEventListener("click",
    function(){
        let below = true
        let class_name
        for(var i=0; i < ratings.length; i++){
            if (ratings[i] === element){
                below = false
                class_name = document.getElementById(element).className
                if (class_name.includes("unchecked")){
                    document.getElementById(element).classList.remove("unchecked")
                    document.getElementById(element).classList.add("checked")
                }
                // set value
                document.getElementById("ratingScore").setAttribute('value', i+1)
            }
            else if (below){
                curr_id = ratings[i]
                class_name = document.getElementById(curr_id).className
                if (class_name.includes("unchecked")){
                    document.getElementById(curr_id).classList.remove("unchecked")
                    document.getElementById(curr_id).classList.add("checked")
                }
            }
            else{
                curr_id = ratings[i]
                class_name = document.getElementById(curr_id).className
                if (class_name.includes("checked")){
                    document.getElementById(curr_id).classList.remove("checked")
                    document.getElementById(curr_id).classList.add("unchecked")
                }
            }
        }  
        
    })
});