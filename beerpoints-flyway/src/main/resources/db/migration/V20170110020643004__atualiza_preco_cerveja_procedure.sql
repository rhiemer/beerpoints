DELIMITER $$
DROP PROCEDURE IF EXISTS PR_ATUALIZA_PRECO_MEDIO_CERVEJA;
CREATE PROCEDURE PR_ATUALIZA_PRECO_MEDIO_CERVEJA(IN p_cerveja_id int)
BEGIN
  DECLARE v_preco_medio decimal(10,5);
	SELECT 
      AVG(preco)
	into 
       v_preco_medio 
    FROM tb_bar_cerveja bc
    where bc.cerveja_id = p_cerveja_id
    and   bc.ativo = 'S'
    and   nvl(bc.preco,0) > 0;
    
    update tb_cerveja c set precoMedio=v_preco_medio
    where  c.cerveja_id = p_cerveja_id 
    ;
    
END$$

