/**
 * https://www.codewars.com/kata/515bb423de843ea99400000a
 * For this exercise you will be strengthening your page-fu mastery. You will complete the PaginationHelper class, 
 * which is a utility class helpful for querying paging information related to an array.
 * The class is designed to take in an array of values and an integer indicating how many items will be allowed per each page. 
 * he types of values contained within the collection/array are not relevant.
 * 
 * The following are some examples of how this class is used:
 * 
 * var helper = new PaginationHelper(['a','b','c','d','e','f'], 4);
 * helper.pageCount(); //should == 2
 * helper.itemCount(); //should == 6
 * helper.pageItemCount(0); //should == 4
 * helper.pageItemCount(1); // last page - should == 2
 * helper.pageItemCount(2); // should == -1 since the page is invalid
 * 
 * pageIndex takes an item index and returns the page that it belongs on
 * helper.pageIndex(5); //should == 1 (zero based index)
 * helper.pageIndex(2); //should == 0
 * helper.pageIndex(20); //should == -1
 * helper.pageIndex(-10); //should == -1

 */

function PaginationHelper(collection, itemsPerPage){
    this.collection = collection;
    this.itemsPerPage = itemsPerPage;  
    this.pages = Math.ceil(this.collection.length / this.itemsPerPage);  
}

// returns the number of items within the entire collection
PaginationHelper.prototype.itemCount = function() {
    return this.collection.length;
  
}

// returns the number of pages
PaginationHelper.prototype.pageCount = function() {
    return this.pages;
  
}

// returns the number of items on the current page. page_index is zero based.
// this method should return -1 for pageIndex values that are out of range
PaginationHelper.prototype.pageItemCount = function(pageIndex) {
    return pageIndex < this.pageCount() 
    ? Math.min(this.itemsPerPage, this.collection.length - (pageIndex * this.itemsPerPage))
    : -1;       
}

// determines what page an item is on. Zero based indexes
// this method should return -1 for itemIndex values that are out of range
PaginationHelper.prototype.pageIndex = function(itemIndex) {
    return itemIndex < this.collection.length && itemIndex >= 0
    ? Math.floor(itemIndex / this.itemsPerPage)
    : -1;   
}

//----- Test Cases ---//
test("PaginationHelper of ['a','b','c','d','e','f'], 4) ", () => {
    let pagHelper = new PaginationHelper(['a','b','c','d','e','f', 'g'], 4);
    expect(pagHelper.itemCount()).toStrictEqual(7);
    expect(pagHelper.pageCount()).toStrictEqual(2);
    expect(pagHelper.pageItemCount(0)).toStrictEqual(4);
    expect(pagHelper.pageItemCount(1)).toStrictEqual(3);
    expect(pagHelper.pageItemCount(2)).toStrictEqual(-1);
    expect(pagHelper.pageIndex(5)).toStrictEqual(1);
    expect(pagHelper.pageIndex(3)).toStrictEqual(0);
});

test("PaginationHelper of [], 4) ", () => {
    let pagHelper = new PaginationHelper([], 4);
    expect(pagHelper.itemCount()).toStrictEqual(0);
    expect(pagHelper.pageCount()).toStrictEqual(0);
    expect(pagHelper.pageItemCount(0)).toStrictEqual(-1);
    expect(pagHelper.pageIndex(0)).toStrictEqual(-1);

});