package <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.web.rest;

import <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.model.<%= entityClass %>;
import <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.service.<%= entityClass %>Service;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;

/**
 * Rest controller. <%= entityClass %>
 */
@Slf4j
@RestController
@RequestMapping("")
class <%= entityClass %>Resource{
    
    @Autowired
    private <%= entityClass %>Service service;

     /** 
     * Get /<%= tableName %> : Create a new <%= tableName %>
     *
     * @param <%= entityClassCamelCase %> the <%= tableName %> to create
     * @return the ResponseEntity with status 200 (OK) and with body the new <%= entityClassCamelCase %>
     */
    @PostMapping("/<%= tableName %>")
    public ResponseEntity<<%= entityClass %>> create<%= entityClass %>(@Valid @RequestBody  <%= entityClass %> <%= entityClassCamelCase %>) {
        log.debug("REST request to save <%= entityClass %> : {}", <%= entityClassCamelCase %>);
        service.save(<%= entityClassCamelCase %>);
        return ResponseEntity.ok(<%= entityClassCamelCase %>);
    }

    /**
     * PUT /<%= tableName %> : Updates an existing <%= tableName %>
     *
     * @param <%= entityClassCamelCase %> the <%= tableName %> to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated <%= tableName %>
     */
    @PutMapping("/<%= tableName %>")
    public ResponseEntity<<%= entityClass %>> update<%= entityClass %>(@Valid @RequestBody  <%= entityClass %> <%= entityClassCamelCase %>) {
        log.debug("REST request to update <%= entityClass %> : {}", <%= entityClassCamelCase %>);
        service.updateById(<%= entityClassCamelCase %>);
        return ResponseEntity.ok(<%= entityClassCamelCase %>);
    }

    /**
     * GET /<%= tableName %> : get all <%= tableName %>.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all <%= tableName %>
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/<%= tableName %>")
    @ApiOperation(value = "get all <%= tableName %>.", response = Page.class)
    public ResponseEntity<Page<<%= entityClass %>>> getAll<%= entityClass %>(@ApiParam Page<<%= entityClass %>> pageable) {
        Page page = (Page)service.page(pageable);
        return ResponseEntity.ok(page);
    }

    /**
     * GET /<%= tableName %>/info : get the "id" <%= tableName %>
     *
     * @param id the id of the <%= tableName %> to find
     * @return
     */
    @GetMapping("/<%= tableName %>/info")
    @ApiOperation(value = "get the \"id\" <%= tableName %>", response = <%= entityClass %>.class)
    public ResponseEntity<<%= entityClass %>> get<%= entityClass %>(@RequestParam  String id) {
        log.debug("REST request to get <%= entityClass %> : {}", id);
        <%= entityClass %> entity = service.getById(id);
        return ResponseEntity.ok(entity);
    }

    /**
     * DELETE /<%= tableName %> : delete the "id" <%= tableName %>.
     *
     * @param id the id of the <%= tableName %> to delete
     * @return
     */
    @DeleteMapping("/<%= tableName %>")
    public void delete<%= entityClass %>(@RequestParam String id) {
        log.debug("REST request to delete <%= entityClass %> : {}", id);
        service.removeById(id);
    }
}
