using System;
using Xunit;

namespace TrainigTDD
{
    public class LikesTest
    {
        [Fact]
        public void likesTest() 
        {
            Likes likes = new Likes();
            Assert.Equal("no one likes this", likes.whoLikes(new string[0]));
            Assert.Equal("Peter likes this", likes.whoLikes(new string[] { "Peter" }));
            Assert.Equal("Jacob and Alex like this", likes.whoLikes(new string[] { "Jacob", "Alex" }));
            Assert.Equal("Max, John and Mark like this", likes.whoLikes(new string[] { "Max", "John", "Mark" }));
            Assert.Equal("Alex, Jacob and 2 others like this", likes.whoLikes(new string[] { "Alex", "Jacob", "Mark", "Max" }));

        }
    }

    public class Likes
    {
        internal String whoLikes(string[] vs)
        {            
            int size = vs.Length;
            return size switch
            {
                0 => "no one likes this",
                1 => vs[0] + " likes this",
                2 => vs[0] + " and " + vs[1] + " like this",
                3 => vs[0] +", " + vs[1] + " and " + vs[2] + " like this",
                _ => vs[0] + ", " + vs[1] + " and " + (vs.Length - 2) + " others like this"
            };
        }
    }
}
