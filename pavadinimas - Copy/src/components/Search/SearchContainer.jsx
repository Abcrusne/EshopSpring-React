import React, { useState, useEffect } from 'react';
import SearchBar from './SearchBar';
import myUrl from '../../AppConfig';
import ProductList from '../Product/ProductListContainer';

const SearchPage = (props) => {
  const [input, setInput] = useState('');
  const [productListDefault, setProductListDefault] = useState();
  const [productList, setProductList] = useState();

  const fetchData = async () => {
    return await fetch(`${myUrl}/api/products`)
      .then((response) => response.json())
      .then((data) => {
        setProductList(data);
        setProductListDefault(data);
      });
  };

  const updateInput = async (input) => {
    const filtered = productListDefault.filter((product) => {
      return product.title.toLowerCase().includes(input.toLowerCase());
    });
    setInput(input);
    setProductList(filtered);
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <>
      <h1>Product List</h1>
      <SearchBar input={input} onChange={updateInput} />
      <ProductList productList={productList} />
    </>
  );
};

export default SearchPage;
