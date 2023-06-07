package mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {

    /* PageInfo{
>
> pageNum=8, pageSize=4, size=2, startRow=29, endRow=30, total=30, pages=8,
>
> list=Page{count=true, pageNum=8, pageSize=4, startRow=28, endRow=32, total=30,
>
> pages=8, reasonable=false, pageSizeZero=false},
>
> prePage=7, nextPage=0, isFirstPage=false, isLastPage=true, hasPreviousPage=true,
>
> hasNextPage=false, navigatePages=5, navigateFirstPage4, navigateLastPage8,
>
> navigatepageNums=[4, 5, 6, 7, 8]
>
> }
>
> pageNum：当前页的页码
>
> pageSize：每页显示的条数
>
> size：当前页显示的真实条数
>
> total：总记录数
>
> pages：总页数
>
> prePage：上一页的页码
>
> nextPage：下一页的页码
>
> isFirstPage/isLastPage：是否为第一页/最后一页
>
> hasPreviousPage/hasNextPage：是否存在上一页/下一页
>
> navigatePages：导航分页的页码数
>
> navigatepageNums：导航分页的页码，[1,2,3,4,5]*/

    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(5, 4);
        List<Emp> list = mapper.selectByExample(null);
        //查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
        list.forEach(System.out::println);
        System.out.println(pageInfo);

    }
}
