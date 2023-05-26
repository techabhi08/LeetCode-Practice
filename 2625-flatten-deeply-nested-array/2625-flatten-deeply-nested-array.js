/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var flat = function (arr, n) {
    let isNested = true;
    let level = 0;
    
    while(isNested && level < n){
        isNested = false;
        let newArr = [];
        
        for(let i = 0; i < arr.length; i++){
            if(Array.isArray(arr[i])){
                newArr.push(...arr[i]);
                isNested = true;
            }else{
                newArr.push(arr[i]);
            }
        }
        arr = [...newArr];
        level++;
    }
    return arr;
};