using System;
using System.Collections.Generic;
using System.Text;
using Xunit;
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
namespace TrainigTDD
{
    public class PaginationHelperTest
    {
        private readonly IList<int> collection = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
        private PaginationHelper<int> paginationHelper;
        public PaginationHelperTest() 
        {
            paginationHelper = new PaginationHelper<int>(collection, 10);
        }
        [Fact]
        public void should_validate_page_item_counts() 
        {
            Assert.Equal(24, paginationHelper.ItemCount);
        }

        [Fact]
        public void should_validate_page_counts()
        {
            Assert.Equal(3, paginationHelper.PageCount);
        }

        [Theory]
        [InlineData(-1, -1)]
        [InlineData(1, 12)]
        [InlineData(-1, 24)]
        public void should_validate_page_index(int expected, int pageIndex)
        {
            Assert.Equal(expected, paginationHelper.PageIndex(pageIndex));
        }

        [Theory]
        [InlineData(-1, -1)]
        [InlineData(10, 1)]
        [InlineData(-1, 3)]
        public void should_validate_page_item_count(int expected, int pageIndex)
        {
            Assert.Equal(expected, paginationHelper.PageItemCount(pageIndex));
        }

    }

    internal class PaginationHelper<T>
    {    
        private IList<T> collection;
        private int itemsPerPage;
        
        public PaginationHelper(IList<T> collection, int itemsPerPage)
        {
            this.collection = collection;
            this.itemsPerPage = itemsPerPage;           

        }

        public int ItemCount
        {
            get
            {
                return this.collection.Count;
            }
        }
      
        public int PageCount
        {
            get
            {
                return (int)Math.Ceiling((double)collection.Count / itemsPerPage);
            }
        }
        
        public int PageItemCount(int pageIndex)
        {
            return pageIndex < this.PageCount && pageIndex >=0
            ? Math.Min(this.itemsPerPage, this.collection.Count - (pageIndex * this.itemsPerPage))
            : -1;
        }
        
        public int PageIndex(int itemIndex)
        {
            return itemIndex < this.collection.Count && itemIndex >= 0
            ? (int)Math.Floor((double)itemIndex / this.itemsPerPage)
            : -1;
        }
    }
}
